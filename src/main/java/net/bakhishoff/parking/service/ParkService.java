package net.bakhishoff.parking.service;

import lombok.RequiredArgsConstructor;
import net.bakhishoff.parking.exception.NoCapacityError;
import net.bakhishoff.parking.exception.NoDataFoundException;
import net.bakhishoff.parking.model.dto.CarDto;
import net.bakhishoff.parking.model.entity.CapacityForType;
import net.bakhishoff.parking.model.entity.Car;
import net.bakhishoff.parking.model.entity.GarageLevel;
import net.bakhishoff.parking.model.mapper.CarMapper;
import net.bakhishoff.parking.repository.CarRepository;
import net.bakhishoff.parking.repository.GarageLevelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ParkService {

    private final GarageLevelRepository levelRepository;
    private final CarMapper mapper;
    private final CarRepository carRepository;

    public Mono<CarDto> parkCar(Long garageId, Long levelId, CarDto dto) {
        return Mono.just(dto)
                   .publishOn(Schedulers.boundedElastic())
                   .map(carDto -> levelRepository.findByIdAndGarage_Id(levelId, garageId)
                                                 .orElseThrow(NoDataFoundException::new))
                   .flatMap(level -> parkCar(dto, level));
    }

    public Mono<CarDto> leaveCar(Long garageId, Long levelId, Long carId) {
        return Mono.justOrEmpty(carRepository.findCar(carId, levelId, garageId))
                   .publishOn(Schedulers.boundedElastic())
                   .map(car -> {
                       car.setLeaveDate(LocalDateTime.now());
                       return carRepository.save(car);
                   })
                   .map(mapper::toDto);
    }

    @Transactional
    protected synchronized Mono<CarDto> parkCar(CarDto dto, GarageLevel level) {
        return Mono.just(level)
                   .map(GarageLevel::getCars)
                   .flux()
                   .flatMap(Flux::fromIterable)
                   .filter(Car::inGarage)
                   .count()
                   .publishOn(Schedulers.boundedElastic())
                   .mapNotNull(count -> Mono.just(level)
                                            .map(GarageLevel::getCapacityForTypes)
                                            .flux()
                                            .flatMap(Flux::fromIterable)
                                            .filter(capacity -> capacity.forType(dto.getType()))
                                            .map(CapacityForType::getCapacity)
                                            .map(capacity -> capacity - count)
                                            .blockFirst())
                   .filter(count -> count > 0)
                   .hasElement()
                   .flatMap(hasPlace -> hasPlace ? save(dto, level) : Mono.error(new NoCapacityError()));
    }

    @Transactional
    protected Mono<CarDto> save(CarDto dto, GarageLevel level) {
        return Mono.just(dto)
                   .map(carDto -> mapper.toEntity(carDto, level))
                   .map(carRepository::save)
                   .map(mapper::toDto);
    }
}
