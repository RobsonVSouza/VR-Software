package com.vrSolutions.rentalsCar.dto;

import com.vrSolutions.rentalsCar.models.Car;
import java.time.Instant;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandDto {

    private Long id;

    private String name;

    private String description;

    private Instant createdAt;

}
