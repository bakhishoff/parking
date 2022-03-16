package net.bakhishoff.parking.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class GarageLevel {

    @Id
    @GeneratedValue
    private Long id;

    private String label;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;

    @OneToMany(mappedBy = "garageLevel")
    private List<CapacityForType> capacityForTypes;

    @OneToMany(mappedBy = "garageLevel")
    private List<Car> cars;
}
