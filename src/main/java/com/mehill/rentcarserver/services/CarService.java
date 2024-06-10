package com.mehill.rentcarserver.services;

import com.mehill.rentcarserver.entities.Car;
import com.mehill.rentcarserver.repository.CarRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> index() {
        return carRepository.findAll();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }
}
