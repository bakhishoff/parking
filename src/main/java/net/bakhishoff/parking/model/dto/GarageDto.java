package net.bakhishoff.parking.model.dto;

import net.bakhishoff.parking.model.validator.ValidGarage;
import net.bakhishoff.parking.model.validator.ValidGarageLevel;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
public class GarageDto {
    @Null(groups = ValidGarage.class)
    @NotNull(groups = ValidGarageLevel.class)
    @Min(value = 1, groups = ValidGarageLevel.class)
    private Long id;

    @NotBlank(groups = {ValidGarage.class})
    @Null(groups = {ValidGarageLevel.class})
    private String name;
}
