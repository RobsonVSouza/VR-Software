package com.vrSolutions.rentalsCar.dto;

import com.vrSolutions.rentalsCar.models.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarImageDto {

    private Long id;

    private String image;

    private Car car;

    private String createdAt;

}
