package com.vrSolutions.rentalsCar.models;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
@Entity
@Table(name = "cars")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "daily_rate")
    private String dailyRate;

    @Column
    private String available;

    @Column(name = "license_plate",unique = true)
    private String licensePlate;

    @OneToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column
    private String color;

    @CreatedDate
    private Instant createdAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car", fetch = FetchType.LAZY)
    private List<Specification> specification;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car", fetch = FetchType.LAZY)
    private List<CarImage> carImages;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id.equals(car.id) && Objects.equals(name, car.name)
                && Objects.equals(description, car.description)
                && Objects.equals(dailyRate, car.dailyRate)
                && Objects.equals(available, car.available) && Objects.equals(
                licensePlate, car.licensePlate) && Objects.equals(brand,
                car.brand) && Objects.equals(category, car.category)
                && Objects.equals(color, car.color) && Objects.equals(
                createdAt, car.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dailyRate, available, licensePlate, brand,
                category, color, createdAt);
    }


}
