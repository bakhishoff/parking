package net.bakhishoff.parking.model.dto;

import lombok.Data;
import net.bakhishoff.parking.model.enums.CarType;
import net.bakhishoff.parking.model.validator.ValidCar;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

@Data
public class CarDto {
    @Null(groups = ValidCar.class)
    private Long id;

    @NotNull(groups = ValidCar.class)
    private CarType type;

    @NotBlank(groups = ValidCar.class)
    private String plateNumber;

    @Null(groups = ValidCar.class)
    private LocalDateTime enterDate;

    @Null(groups = ValidCar.class)
    private LocalDateTime leaveDate;
}
