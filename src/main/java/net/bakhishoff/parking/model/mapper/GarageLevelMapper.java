package net.bakhishoff.parking.model.mapper;

import net.bakhishoff.parking.model.dto.GarageLevelDto;
import net.bakhishoff.parking.model.entity.GarageLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = GarageMapper.class)
public abstract class GarageLevelMapper extends AbstractModelMapper<GarageLevelDto, GarageLevel> {
    @Override
    @Mapping(target = "garage", source = "garage.id")
    public abstract GarageLevel toEntity(GarageLevelDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "garage", source = "garage.id")
    public abstract GarageLevel toEntity(@MappingTarget GarageLevel entity, GarageLevelDto dto);
}
