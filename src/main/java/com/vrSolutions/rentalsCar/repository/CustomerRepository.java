package com.vrSolutions.rentalsCar.repository;


import com.vrSolutions.rentalsCar.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{

    Customer findByDriverLicense(String driverLicense);
}
