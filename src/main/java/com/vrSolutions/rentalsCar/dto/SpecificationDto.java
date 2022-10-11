package com.vrSolutions.rentalsCar.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpecificationDto {

    private Long id;

    private String name;

    private Instant createdAt;

}
