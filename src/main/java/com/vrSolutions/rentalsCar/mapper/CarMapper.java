package com.vrSolutions.rentalsCar.mapper;

import com.vrSolutions.rentalsCar.dto.CarDto;
import com.vrSolutions.rentalsCar.models.Car;
import java.util.List;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class CarMapper {

    public abstract CarDto toDto(Car entity);

    public abstract Car toEntity(CarDto dto);

    public abstract List<CarDto> toListDto(List<Car> entityList);

}
