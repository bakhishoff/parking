package net.bakhishoff.parking.model.mapper;

import net.bakhishoff.parking.model.dto.CarDto;
import net.bakhishoff.parking.model.entity.Car;
import net.bakhishoff.parking.model.entity.GarageLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(imports = LocalDateTime.class)
public abstract class CarMapper extends AbstractModelMapper<CarDto, Car> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "leaveDate", ignore = true)
    @Mapping(target = "enterDate", expression = "java(LocalDateTime.now())")
    public abstract Car toEntity(CarDto carDto, GarageLevel garageLevel);
}
