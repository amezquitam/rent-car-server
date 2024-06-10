package com.mehill.rentcarserver.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "rents")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Car rentedCar;

    @OneToOne(optional = false)
    private Client client;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate pickUpDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate returnDate;

}
