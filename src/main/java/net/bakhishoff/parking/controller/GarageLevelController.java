package net.bakhishoff.parking.controller;

import net.bakhishoff.parking.model.dto.GarageLevelDto;
import net.bakhishoff.parking.model.entity.GarageLevel;
import net.bakhishoff.parking.model.validator.ValidGarageLevel;
import net.bakhishoff.parking.service.GarageLevelService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated(ValidGarageLevel.class)
@RequestMapping("/admin/garage-levels")
public class GarageLevelController extends CrudController<GarageLevelDto, GarageLevel> {

    public GarageLevelController(GarageLevelService service) {
        super(service);
    }
}
