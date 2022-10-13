package com.vrSolutions.rentalsCar.repository;

import com.vrSolutions.rentalsCar.models.Specification;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationRepository extends JpaRepository <Specification, Long> {

   Optional <Specification> findByName(String name);
}
