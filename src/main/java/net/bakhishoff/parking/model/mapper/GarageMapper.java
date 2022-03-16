package net.bakhishoff.parking.model.mapper;

import net.bakhishoff.parking.model.dto.GarageDto;
import net.bakhishoff.parking.model.entity.Garage;
import org.mapstruct.Mapper;

@Mapper
public abstract class GarageMapper extends AbstractModelMapper<GarageDto, Garage> {
}
