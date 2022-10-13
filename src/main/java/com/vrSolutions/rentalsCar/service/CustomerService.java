package com.vrSolutions.rentalsCar.service;

import com.vrSolutions.rentalsCar.dto.CustomerDto;
import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerDto dto);

    CustomerDto update(Long id, CustomerDto dto);

    CustomerDto findById(Long id);

    List<CustomerDto> getAll();

    void delete(Long id);
}
