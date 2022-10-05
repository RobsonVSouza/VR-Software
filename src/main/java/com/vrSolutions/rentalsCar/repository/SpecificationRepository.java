package com.vrSolutions.rentalsCar.repository;

import com.vrSolutions.rentalsCar.models.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationRepository extends JpaRepository <Specification, Long> {

    Specification findByName(String name);
}
