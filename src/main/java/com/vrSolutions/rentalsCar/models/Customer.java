package com.vrSolutions.rentalsCar.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column
    private String email;

    @Column(name = "driver_license")
    private String driverLicense;

    @Column
    private String adress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "update_at")
    private String updateAt;


}
