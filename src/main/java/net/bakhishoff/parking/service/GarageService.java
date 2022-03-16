package net.bakhishoff.parking.service;

import net.bakhishoff.parking.model.dto.GarageDto;
import net.bakhishoff.parking.model.entity.Garage;
import net.bakhishoff.parking.model.mapper.GarageMapper;
import net.bakhishoff.parking.repository.GarageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GarageService extends CrudService<GarageDto, Garage> {
    public GarageService(GarageMapper mapper,
                         GarageRepository repository) {
        super(mapper, repository, "Garage");
    }
}
