package org.example.uberend2end.services;

import java.util.List;

public interface ILocationService {

    Boolean saveDriverLocation(Integer driverId, Double latitude, Double longitude);

    List<?> getNearbyDrivers(Double latitude, Double longitude, Double radius);
    
}