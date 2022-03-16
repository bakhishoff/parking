package net.bakhishoff.parking.repository;

import net.bakhishoff.parking.model.entity.GarageLevel;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface GarageLevelRepository extends JpaRepositoryImplementation<GarageLevel, Long> {

    Optional<GarageLevel> findByIdAndGarage_Id(long id, long garageId);
}
