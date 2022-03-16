package net.bakhishoff.parking.repository;

import net.bakhishoff.parking.model.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author Ulphat
 */
public interface CarRepository extends JpaRepositoryImplementation<Car, Long> {

    @Query("select c from Car c where c.id = ?1 and c.garageLevel.id = ?2 and c.garageLevel.garage.id = ?3")
    Optional<Car> findCar(Long id, Long garageLevelId, Long garageId);
}
