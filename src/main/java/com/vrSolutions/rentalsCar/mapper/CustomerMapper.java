package com.vrSolutions.rentalsCar.mapper;

import com.vrSolutions.rentalsCar.dto.CustomerDto;
import com.vrSolutions.rentalsCar.models.Customer;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    public abstract CustomerDto toDto(Customer entity);

    public abstract Customer toEntity(CustomerDto dto);

    public abstract List<CustomerDto> toListDto(List<Customer> entityList);
}
