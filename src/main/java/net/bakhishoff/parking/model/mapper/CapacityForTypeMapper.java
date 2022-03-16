package net.bakhishoff.parking.model.mapper;

import net.bakhishoff.parking.model.dto.CapacityForTypeDto;
import net.bakhishoff.parking.model.entity.CapacityForType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = GarageLevelMapper.class)
public abstract class CapacityForTypeMapper extends AbstractModelMapper<CapacityForTypeDto, CapacityForType> {

    @Override
    @Mapping(target = "garageLevel", source = "garageLevel.id")
    public abstract CapacityForType toEntity(CapacityForTypeDto capacityForTypeDto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "garageLevel", source = "garageLevel.id")
    public abstract CapacityForType toEntity(@MappingTarget CapacityForType entity, CapacityForTypeDto dto);
}
