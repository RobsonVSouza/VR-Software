package com.vrSolutions.rentalsCar.models;


import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Currency;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@Entity
@Table(name = "rentals")
public class Rental implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne
    @JoinColumn(name = "rental", nullable = false)
    private Car car;

    @OneToOne
    @JoinColumn(name = "customer", nullable = false)
    private  Customer customer;

    @Column
    private Instant startDate;

    @Column
    private Instant endDate;

    @Column
    private Currency total;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updateAt;



}
