package net.bakhishoff.parking.controller;

import net.bakhishoff.parking.model.dto.GarageDto;
import net.bakhishoff.parking.model.entity.Garage;
import net.bakhishoff.parking.model.validator.ValidGarage;
import net.bakhishoff.parking.service.GarageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated(ValidGarage.class)
@RequestMapping("/admin/garages")
public class GarageController extends CrudController<GarageDto, Garage> {

    public GarageController(GarageService service) {
        super(service);
    }
}
