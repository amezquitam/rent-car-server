package com.mehill.rentcarserver.repository;

import com.mehill.rentcarserver.entities.Car;
import com.mehill.rentcarserver.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByRentedCar(Car rentedCar);
}
