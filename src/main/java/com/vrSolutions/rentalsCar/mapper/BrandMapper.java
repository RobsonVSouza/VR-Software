package com.vrSolutions.rentalsCar.mapper;

import com.vrSolutions.rentalsCar.dto.BrandDto;
import com.vrSolutions.rentalsCar.models.Brand;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BrandMapper {

    public abstract BrandDto toDtoBrand(Brand brandEntity);

    public abstract Brand toBrandEntity(BrandDto brandDto);

    public abstract List<BrandDto> toListDto(List<Brand> entityList);


}
