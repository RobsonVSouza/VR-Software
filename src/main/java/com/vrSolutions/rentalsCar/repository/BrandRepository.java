package com.vrSolutions.rentalsCar.repository;

import com.vrSolutions.rentalsCar.models.Brand;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository <Brand, Long> {

   Optional <Brand> findByName(String name);

}
