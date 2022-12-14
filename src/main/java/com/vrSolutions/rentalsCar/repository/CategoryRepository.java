package com.vrSolutions.rentalsCar.repository;


import com.vrSolutions.rentalsCar.models.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {

    Optional <Category> findByName(String name);

}
