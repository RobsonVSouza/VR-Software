package com.vrSolutions.rentalsCar.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String driverLicense;

    private String address;

    private String phoneNumber;

    private Instant createdAt;

    private Instant updateAt;

}
