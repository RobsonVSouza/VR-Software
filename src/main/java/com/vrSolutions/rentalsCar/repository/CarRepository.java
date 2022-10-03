package com.vrSolutions.rentalsCar.repository;

import com.vrSolutions.rentalsCar.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository <Car, Long> {

}
