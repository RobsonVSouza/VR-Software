package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.BrandDto;
import java.util.List;

public interface BrandService {

    BrandDto save(BrandDto dtoBrand);

    BrandDto update(Long id, BrandDto dtoBrand);

    BrandDto findById(Long id);

    List<BrandDto> getAll();

    void delete(Long id);
}
