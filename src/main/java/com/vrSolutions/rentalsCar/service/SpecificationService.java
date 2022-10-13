package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.SpecificationDto;
import java.util.List;

public interface SpecificationService {

    SpecificationDto save(SpecificationDto dto);

    SpecificationDto update(Long id, SpecificationDto dto);

    SpecificationDto findById(Long id);

    List<SpecificationDto> getAll();

    void delete(Long id);
}
