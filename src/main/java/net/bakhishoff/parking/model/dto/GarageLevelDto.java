package net.bakhishoff.parking.model.dto;

import lombok.Data;
import net.bakhishoff.parking.model.validator.ValidCapacityForType;
import net.bakhishoff.parking.model.validator.ValidGarageLevel;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class GarageLevelDto {
    @Null(groups = ValidGarageLevel.class)
    @NotNull(groups = ValidCapacityForType.class)
    @Min(value = 1, groups = ValidCapacityForType.class)
    private Long id;

    @Valid
    @Null(groups = ValidCapacityForType.class)
    @NotNull(groups = ValidGarageLevel.class)
    private GarageDto garage;

    @Null(groups = ValidCapacityForType.class)
    @NotNull(groups = ValidGarageLevel.class)
    private String label;
}
