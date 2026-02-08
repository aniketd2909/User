package org.example.uberend2end.services.implementation;

import lombok.RequiredArgsConstructor;
import org.example.uberend2end.entities.Passenger;
import org.example.uberend2end.repositories.PassengerRepository;
import org.example.uberend2end.services.IPassengerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerService implements IPassengerService {

    private final PassengerRepository passengerRepository;

    @Override
    public Passenger registerPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger getPassengerById(String id) {
            return passengerRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Passenger not found"));
    }

}
