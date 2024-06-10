package com.mehill.rentcarserver.services;

import com.mehill.rentcarserver.entities.Car;
import com.mehill.rentcarserver.entities.Client;
import com.mehill.rentcarserver.entities.Rent;
import com.mehill.rentcarserver.repository.ClientRepository;
import com.mehill.rentcarserver.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentService {
    private final RentRepository rentRepository;
    private final ClientRepository clientRepository;

    public List<Rent> findById(Long carId) {
        Car targetCar = Car.builder().id(carId).build();
        return rentRepository.findByRentedCar(targetCar);
    }

    public Rent save(Rent rentRequest) {
        Client client = clientRepository.save(rentRequest.getClient());
        rentRequest.setClient(client);
        return rentRepository.save(rentRequest);
    }
}
