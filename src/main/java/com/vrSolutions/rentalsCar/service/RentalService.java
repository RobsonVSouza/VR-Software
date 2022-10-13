package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.CustomerDto;
import com.vrSolutions.rentalsCar.dto.RentalDto;
import com.vrSolutions.rentalsCar.models.Rental;
import java.util.List;

public interface RentalService {

    RentalDto save(RentalDto dto);

    RentalDto update(Long id, RentalDto dto);

    RentalDto findById(Long id);

    List<RentalDto> getAll();

    void delete(Long id);

}
