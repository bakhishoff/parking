package net.bakhishoff.parking.repository;

import net.bakhishoff.parking.model.entity.Garage;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface GarageRepository extends JpaRepositoryImplementation<Garage, Long> {
}
