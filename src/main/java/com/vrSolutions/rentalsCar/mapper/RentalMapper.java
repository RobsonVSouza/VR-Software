package com.vrSolutions.rentalsCar.mapper;

import com.vrSolutions.rentalsCar.dto.CustomerDto;
import com.vrSolutions.rentalsCar.dto.RentalDto;
import com.vrSolutions.rentalsCar.models.Customer;
import com.vrSolutions.rentalsCar.models.Rental;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RentalMapper {


    public abstract RentalDto toDto(Rental entity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    public abstract Rental toEntity(RentalDto dto);

    public abstract List<RentalDto> toListDto(List<Rental> entityList);

}
