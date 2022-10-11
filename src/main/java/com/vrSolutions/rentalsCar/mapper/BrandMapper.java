package com.vrSolutions.rentalsCar.mapper;

import com.vrSolutions.rentalsCar.dto.BrandDto;
import com.vrSolutions.rentalsCar.models.Brand;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public abstract class BrandMapper {

    public abstract BrandDto toDtoBrand(Brand brandEntity);

    @Mapping(target = "createdAt", ignore = true)
    public abstract Brand toBrandEntity(BrandDto brandDto);

    public abstract List<BrandDto> toListDto(List<Brand> entityList);


}
