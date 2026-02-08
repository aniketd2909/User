package org.example.uberend2end.services;

import org.example.uberend2end.entities.Driver;
import java.util.List;

public interface IDriverService {

    Driver registerDriver(Driver driver);
    Driver getDriverById(String id);
    List<Driver> getAllDrivers();

}
