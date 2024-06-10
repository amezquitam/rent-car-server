package com.mehill.rentcarserver.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars", uniqueConstraints = @UniqueConstraint(name = "unique_car", columnNames = {"model"}))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private Integer year;

    @Column
    private String image;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private Double pricePerDay;
}