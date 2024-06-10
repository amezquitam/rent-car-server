package com.mehill.rentcarserver.controller;

import com.mehill.rentcarserver.entities.Car;
import com.mehill.rentcarserver.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/cars")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Car>> index() {
        List<Car> cars = carService.index();
        return ResponseEntity.ok(cars);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Car> create(@RequestBody Car car) {
        Car savedCar = carService.save(car);
        return ResponseEntity.ok(savedCar);
    }
}
