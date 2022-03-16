package net.bakhishoff.parking.model.entity;

import net.bakhishoff.parking.model.enums.CarType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String plateNumber;

    private LocalDateTime enterDate;
    private LocalDateTime leaveDate;

    @Enumerated
    private CarType type;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private GarageLevel garageLevel;

    public boolean inGarage() {
        return leaveDate == null;
    }
}
