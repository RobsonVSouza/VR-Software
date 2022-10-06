package com.vrSolutions.rentalsCar.dto;

import com.vrSolutions.rentalsCar.models.Car;
import com.vrSolutions.rentalsCar.models.Specification;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarsSpecificationDto {

    private Long id;

    private Car car;

    private List<Specification> specifications;
}
