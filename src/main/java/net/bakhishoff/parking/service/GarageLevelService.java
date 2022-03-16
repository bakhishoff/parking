package net.bakhishoff.parking.service;

import net.bakhishoff.parking.model.dto.GarageLevelDto;
import net.bakhishoff.parking.model.entity.GarageLevel;
import net.bakhishoff.parking.model.mapper.GarageLevelMapper;
import net.bakhishoff.parking.repository.GarageLevelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GarageLevelService extends CrudService<GarageLevelDto, GarageLevel> {
    public GarageLevelService(GarageLevelMapper mapper,
                              GarageLevelRepository repository) {
        super(mapper, repository, "Garage Level");
    }
}

