package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.CategoryDto;
import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto update(Long id, CategoryDto dto);

    CategoryDto findById(Long id);

    List<CategoryDto> getAll();

    void delete(Long id);
}
