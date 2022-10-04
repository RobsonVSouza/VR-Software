package com.vrSolutions.rentalsCar.repository;

import com.vrSolutions.rentalsCar.models.Brand;
import com.vrSolutions.rentalsCar.models.Car;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository <Brand, Long> {

    Brand findByName(String name);

    Brand findByCar(Set<Car> cars);
}
