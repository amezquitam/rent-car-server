package com.mehill.rentcarserver.controller;

import com.mehill.rentcarserver.entities.Rent;
import com.mehill.rentcarserver.services.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/rents")
@CrossOrigin("*")
@RequiredArgsConstructor
public class RentController {
    private final RentService rentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Rent>> index(@RequestParam Long carId) {
        List<Rent> rents = rentService.findById(carId);
        return ResponseEntity.ok(rents);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Rent> create(@RequestBody Rent rentRequest) {
        Rent rent = rentService.save(rentRequest);
        return ResponseEntity.ok(rent);
    }
}

