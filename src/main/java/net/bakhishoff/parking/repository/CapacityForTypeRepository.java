package net.bakhishoff.parking.repository;

import net.bakhishoff.parking.model.entity.CapacityForType;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CapacityForTypeRepository extends JpaRepositoryImplementation<CapacityForType, Long> {
}
