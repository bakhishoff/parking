package net.bakhishoff.parking.model.dto;

import lombok.Data;
import net.bakhishoff.parking.model.enums.CarType;
import net.bakhishoff.parking.model.validator.ValidCapacityForType;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class CapacityForTypeDto {

    @Null(groups = ValidCapacityForType.class)
    private Long id;

    @Valid
    @NotNull(groups = ValidCapacityForType.class)
    private GarageLevelDto garageLevel;

    @NotNull(groups = ValidCapacityForType.class)
    private CarType type;

    @NotNull(groups = ValidCapacityForType.class)
    @Min(value = 1, groups = ValidCapacityForType.class)
    private Integer capacity;
}
