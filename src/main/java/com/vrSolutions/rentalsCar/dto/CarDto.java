package com.vrSolutions.rentalsCar.dto;

import com.vrSolutions.rentalsCar.models.Brand;
import com.vrSolutions.rentalsCar.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
