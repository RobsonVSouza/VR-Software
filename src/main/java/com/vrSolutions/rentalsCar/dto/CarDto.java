package com.vrSolutions.rentalsCar.dto;

import com.vrSolutions.rentalsCar.models.Brand;
import com.vrSolutions.rentalsCar.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDto {

    private Long id;

    private String name;

    private String description;

    private String dailyRate;

    private String avaliable;

    private String licensePlate;

    private Brand brand;

    private Category category;

    private String color;

    private String createdAt;

}
