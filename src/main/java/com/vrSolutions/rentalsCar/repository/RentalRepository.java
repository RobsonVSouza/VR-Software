package com.vrSolutions.rentalsCar.repository;

import com.vrSolutions.rentalsCar.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository <Rental, Long> {

}
