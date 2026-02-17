package org.example.uberend2end.services;

import java.util.List;

import org.example.uberend2end.dtos.DriverLocationDTO;


public interface ILocationService {

    Boolean saveDriverLocation(String driverId, Double latitude, Double longitude);

    List<DriverLocationDTO> getNearbyDrivers(Double latitude, Double longitude, Double radius);
    
}