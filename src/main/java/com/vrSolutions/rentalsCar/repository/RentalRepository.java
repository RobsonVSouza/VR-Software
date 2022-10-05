package com.vrSolutions.rentalsCar.repository;

import com.vrSolutions.rentalsCar.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository <Rental, Long> {

}
