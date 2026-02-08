package org.example.uberend2end.services.onboarding;

import lombok.RequiredArgsConstructor;
import org.example.uberend2end.entities.Passenger;
import org.example.uberend2end.entities.Role;
import org.example.uberend2end.entities.User;
import org.example.uberend2end.repositories.PassengerRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PassengerProfileCreator implements IProfileCreator {

    private final PassengerRepository passengerRepository;

    @Override
    public boolean supports(Role role) {
        return role == Role.PASSENGER;
    }

    @Override
    public void createProfile(User user) {
        Passenger passenger = new Passenger();
        passenger.setUserId(user.getId());
        passenger.setRating(0.0);
        passengerRepository.save(passenger);
    }
}
