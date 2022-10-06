package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.CarDto;
import com.vrSolutions.rentalsCar.models.Car;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

public interface CarService {


    CarDto save(CarDto dto);

    CarDto update(CarDto dto);

    CarDto findById(Long id);

    List<CarDto> getAll();

    void delete(Long id);
}
