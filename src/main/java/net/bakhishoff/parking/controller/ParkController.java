package net.bakhishoff.parking.controller;

import net.bakhishoff.parking.model.dto.CarDto;
import net.bakhishoff.parking.service.ParkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/park")
public class ParkController {

    private final ParkService service;

    @PostMapping("/park-car/garage/{garageId}/level/{levelId}")
    public Mono<CarDto> parkCar(@PathVariable Long garageId,
                                @PathVariable Long levelId,
                                @RequestBody CarDto dto) {
        return service.parkCar(garageId, levelId, dto);
    }

    @GetMapping("/leave-car/garage/{garageId}/level/{levelId}/car/{carId}")
    public Mono<CarDto> leaveCar(@PathVariable Long garageId,
                         @PathVariable Long levelId,
                         @PathVariable Long carId) {
        return service.leaveCar(garageId, levelId, carId);
    }
}
