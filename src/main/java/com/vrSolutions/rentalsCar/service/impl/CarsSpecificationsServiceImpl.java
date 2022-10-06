package com.vrSolutions.rentalsCar.service.impl;

import com.vrSolutions.rentalsCar.mapper.CarsSpecificationsMapper;
import com.vrSolutions.rentalsCar.repository.CarsSpecificationRepository;
import com.vrSolutions.rentalsCar.service.CarsSpecificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarsSpecificationsServiceImpl implements CarsSpecificationsService {

    @Autowired
    private static CarsSpecificationRepository carsSpecificationRepository;

    @Autowired
    private static CarsSpecificationsMapper carsSpecificationsMapper;


}
