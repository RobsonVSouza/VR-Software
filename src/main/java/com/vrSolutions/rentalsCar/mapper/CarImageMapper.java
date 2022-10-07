package com.vrSolutions.rentalsCar.mapper;

import com.vrSolutions.rentalsCar.dto.CarImageDto;
import com.vrSolutions.rentalsCar.models.CarImage;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CarImageMapper {

    public abstract CarImageDto toDto(CarImage entity);

    public abstract CarImage toEntity(CarImageDto dto);

    public abstract List<CarImageDto> toListDto(List<CarImage> entityList);


}
