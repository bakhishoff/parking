package net.bakhishoff.parking.model.entity;

import net.bakhishoff.parking.model.enums.CarType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"garage_level_id", "type"}))
public class CapacityForType {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "garage_level_id")
    private GarageLevel garageLevel;

    @Enumerated
    private CarType type;

    private int capacity;

    public boolean forType(CarType type) {
        return this.type == type;
    }
}
