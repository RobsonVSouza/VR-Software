package com.vrSolutions.rentalsCar.mapper;

import com.vrSolutions.rentalsCar.dto.CarsSpecificationDto;
import com.vrSolutions.rentalsCar.models.CarsSpecification;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CarsSpecificationsMapper {

    public abstract CarsSpecificationDto toDto(CarsSpecification entity);

    public abstract CarsSpecification toEntity(CarsSpecificationDto dto);

    public abstract List<CarsSpecificationDto> toListDto(List<CarsSpecification> entityList);

}
