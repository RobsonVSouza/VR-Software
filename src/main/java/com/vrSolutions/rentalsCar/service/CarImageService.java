package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.CarImageDto;
import java.util.List;

public interface CarImageService {

    CarImageDto save(CarImageDto dto);

    CarImageDto update(CarImageDto dto);

    CarImageDto findById(Long id);

    List<CarImageDto> getAll();

    void delete(Long id);
}
