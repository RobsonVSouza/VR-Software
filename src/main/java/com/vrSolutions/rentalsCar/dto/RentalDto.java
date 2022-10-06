package com.vrSolutions.rentalsCar.dto;

import com.vrSolutions.rentalsCar.models.Car;
import com.vrSolutions.rentalsCar.models.Customer;
import java.time.LocalDateTime;
import java.util.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalDto {

    private Long id;

    private Car car;

    private Customer customer;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Currency total;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

}
