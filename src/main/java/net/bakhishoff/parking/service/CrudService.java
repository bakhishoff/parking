package net.bakhishoff.parking.service;

import lombok.RequiredArgsConstructor;
import net.bakhishoff.parking.exception.NoDataFoundException;
import net.bakhishoff.parking.model.mapper.ModelMapper;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class CrudService<Dto, Entity> {

    protected final ModelMapper<Dto, Entity> mapper;
    protected final JpaRepositoryImplementation<Entity, Long> repository;
    protected final String resourceName;

    public Dto create(Dto dto) {
        return Mono.just(dto)
                   .map(mapper::toEntity)
                   .map(repository::save)
                   .map(mapper::toDto)
                   .switchIfEmpty(Mono.error(IllegalArgumentException::new))
                   .block();
    }

    public List<Dto> list() {
        return repository.findAll()
                         .stream()
                         .map(mapper::toDto)
                         .collect(Collectors.toList());
    }

    public Dto getById(Long id) {
        return findById(id).map(mapper::toDto)
                           .orElseThrow(() -> noDataFound(id));
    }

    public Dto updateById(Long id, Dto dto) {
        return findById(id).map(entity -> mapper.toEntity(entity, dto))
                           .map(repository::save)
                           .map(mapper::toDto)
                           .orElseThrow(() -> noDataFound(id));
    }

    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            noDataFound(id);
        }
    }

    protected Optional<Entity> findById(Long id) {
        return repository.findById(id);
    }

    protected NoDataFoundException noDataFound(Long id) {
        return NoDataFoundException.ofResourceNameAndId(resourceName, String.valueOf(id));
    }
}
