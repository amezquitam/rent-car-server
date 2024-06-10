package com.mehill.rentcarserver.repository;

import com.mehill.rentcarserver.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
