package net.bakhishoff.parking.service;

import net.bakhishoff.parking.model.dto.CapacityForTypeDto;
import net.bakhishoff.parking.model.entity.CapacityForType;
import net.bakhishoff.parking.model.mapper.CapacityForTypeMapper;
import net.bakhishoff.parking.repository.CapacityForTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CapacityForTypeService extends CrudService<CapacityForTypeDto, CapacityForType> {
    public CapacityForTypeService(CapacityForTypeMapper mapper,
                                  CapacityForTypeRepository repository) {
        super(mapper, repository, "CapacityForType");
    }
}

