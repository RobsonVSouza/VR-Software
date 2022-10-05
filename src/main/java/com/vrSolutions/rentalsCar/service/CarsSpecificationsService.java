package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.mapper.CarsSpecificationsMapper;
import com.vrSolutions.rentalsCar.repository.CarsSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarsSpecificationsService {

    @Autowired
    private static CarsSpecificationRepository carsSpecificationRepository;

    @Autowired
    private static CarsSpecificationsMapper carsSpecificationsMapper;





}
