package com.vrSolutions.rentalsCar.mapper;

import com.vrSolutions.rentalsCar.dto.SpecificationDto;
import com.vrSolutions.rentalsCar.models.Specification;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class SpecificationMapper {

    public abstract SpecificationDto toDto(Specification entity);

    public abstract Specification toEntity(SpecificationDto dto);

    public abstract List<SpecificationDto> toListDto(List<Specification> entityList);

}
