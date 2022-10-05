package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.CarDto;
import com.vrSolutions.rentalsCar.dto.CarsSpecificationDto;
import com.vrSolutions.rentalsCar.mapper.CarsSpecificationsMapper;
import com.vrSolutions.rentalsCar.models.Car;
import com.vrSolutions.rentalsCar.repository.CarsSpecificationRepository;
import javax.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarsSpecificationsService {

    @Autowired
    private static CarsSpecificationRepository carsSpecificationRepository;

    @Autowired
    private static CarsSpecificationsMapper carsSpecificationsMapper;



}
