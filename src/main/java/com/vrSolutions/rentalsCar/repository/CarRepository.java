package com.vrSolutions.rentalsCar.repository;

import com.vrSolutions.rentalsCar.models.Car;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository <Car, Long> {

    Optional<Car> findById(Long id);

    Car findByLicensePlate(String licensePlate);
}
