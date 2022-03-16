package net.bakhishoff.parking.model.mapper;

import org.mapstruct.MapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

@MapperConfig
public abstract class AbstractModelMapper<Dto, Entity> implements ModelMapper<Dto, Entity> {

    @Autowired
    protected JpaRepositoryImplementation<Entity, Long> repository;

    public Entity idToEntity(Long id) {
        return Optional.ofNullable(id)
                       .flatMap(repository::findById)
                       .orElseThrow(IllegalArgumentException::new);
    }
}
