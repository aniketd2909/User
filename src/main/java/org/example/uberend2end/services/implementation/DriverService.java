package org.example.uberend2end.services.implementation;

import lombok.RequiredArgsConstructor;
import org.example.uberend2end.entities.Driver;
import org.example.uberend2end.repositories.DriverRepository;
import org.example.uberend2end.services.IDriverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService implements IDriverService {

    private final DriverRepository driverRepository;

    @Override
    public Driver registerDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver getDriverById(String id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll().stream().toList();
    }
}
