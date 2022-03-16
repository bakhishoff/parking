package net.bakhishoff.parking.controller;

import net.bakhishoff.parking.model.dto.CapacityForTypeDto;
import net.bakhishoff.parking.model.entity.CapacityForType;
import net.bakhishoff.parking.model.validator.ValidCapacityForType;
import net.bakhishoff.parking.service.CapacityForTypeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated(ValidCapacityForType.class)
@RequestMapping("/admin/capacity-for-types")
public class CapacityController extends CrudController<CapacityForTypeDto, CapacityForType> {

    public CapacityController(CapacityForTypeService service) {
        super(service);
    }

}
