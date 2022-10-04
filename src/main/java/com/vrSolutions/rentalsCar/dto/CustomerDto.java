package com.vrSolutions.rentalsCar.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String driverLicense;

    private String adress;

    private String phoneNumber;

    private String createdAt;

    private String updateAt;

}
