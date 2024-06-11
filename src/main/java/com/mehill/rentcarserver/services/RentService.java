package com.mehill.rentcarserver.services;

import com.mehill.rentcarserver.entities.Car;
import com.mehill.rentcarserver.entities.Client;
import com.mehill.rentcarserver.entities.Rent;
import com.mehill.rentcarserver.repository.ClientRepository;
import com.mehill.rentcarserver.repository.RentRepository;
import com.mehill.rentcarserver.util.exception.DateCollisionException;
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
        List<Rent> rentsOfRequestedCar = rentRepository.findByRentedCar(rentRequest.getRentedCar());

        boolean rentHasDateCollision = rentsOfRequestedCar.stream()
                .anyMatch(rent ->
                        (rent.getPickUpDate().isEqual(rentRequest.getPickUpDate()) || rent.getReturnDate().isEqual(rentRequest.getReturnDate())) ||
                        (rent.getPickUpDate().isEqual(rentRequest.getReturnDate()) || rent.getReturnDate().isEqual(rentRequest.getPickUpDate())) ||
                        (rent.getPickUpDate().isAfter(rentRequest.getPickUpDate()) && rent.getReturnDate().isBefore(rentRequest.getPickUpDate())) ||
                        (rent.getPickUpDate().isAfter(rentRequest.getReturnDate()) && rent.getReturnDate().isBefore(rentRequest.getReturnDate()))
                );

        if (rentHasDateCollision) {
            throw new DateCollisionException("The requested rent dates produces a collision with others rents' dates");
        }

        Client client = clientRepository.save(rentRequest.getClient());
        rentRequest.setClient(client);
        return rentRepository.save(rentRequest);
    }
}
