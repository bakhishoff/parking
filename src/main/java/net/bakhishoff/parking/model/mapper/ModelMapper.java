package net.bakhishoff.parking.model.mapper;


import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@MapperConfig
public interface ModelMapper<Dto, Entity> {

    Entity toEntity(Dto dto);

    List<Entity> toEntity(List<Dto> dtos);

    @Mapping(target = "id", ignore = true)
    Entity toEntity(@MappingTarget Entity entity, Dto dto);

    Dto toDto(Entity entity);

    List<Dto> toDto(List<Entity> entity);
}
