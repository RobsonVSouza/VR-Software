package com.vrSolutions.rentalsCar.repository;


import com.vrSolutions.rentalsCar.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long>{

}
