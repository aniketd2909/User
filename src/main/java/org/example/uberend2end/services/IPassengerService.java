package org.example.uberend2end.services;

import org.example.uberend2end.entities.Passenger;

public interface IPassengerService {

    Passenger registerPassenger(Passenger passenger);

    Passenger getPassengerById(String id);

}
