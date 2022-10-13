package com.vrSolutions.rentalsCar.repository;


import com.vrSolutions.rentalsCar.models.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarImageRepository extends JpaRepository<CarImage, Long> {

    CarImage findByImage(String image);
}
