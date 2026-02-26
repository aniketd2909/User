package org.example.uberend2end.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.example.uberend2end.dtos.DriverLocationDTO;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.connection.RedisGeoCommands.GeoLocation;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DriverLocationService {

    private static final String DRIVER_GEO_OPS_KEY = "driver:geo"; // represent location of driver entity in redis
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * Saves or updates a driver's current location in Redis.
     * @param driverId The ID of the driver.
     * @param longitude The longitude of the driver.
     * @param latitude The latitude of the driver.
     */
    public Boolean saveDriverLocation(String driverId, double longitude, double latitude) {
        GeoOperations<String, String> geoOperations = stringRedisTemplate.opsForGeo();
        geoOperations.add(DRIVER_GEO_OPS_KEY,
            new RedisGeoCommands.GeoLocation<>(driverId, new Point(latitude, longitude))
        );
        return true;
    }

    /**
     * Finds drivers within a specified radius of a given passenger location.
     * @param latitude The longitude of the passenger's pickup location.
     * @param longitude The latitude of the passenger's pickup location.
     * @param radius The search radius in kilometers.
     * @return A list of driver IDs found within the radius.
     */
    public List<DriverLocationDTO> findNearbyDrivers(Double latitude, Double longitude, Double radius) {
        GeoOperations<String, String> geoOperations = stringRedisTemplate.opsForGeo();
        Distance circleRadius = new Distance(radius, Metrics.KILOMETERS); // Radius in kilometers
        Circle circle = new Circle(new Point(latitude, longitude), circleRadius);
        GeoResults<GeoLocation<String>> results = geoOperations.radius(DRIVER_GEO_OPS_KEY, circle); // query redis

        List<DriverLocationDTO> driverLocations = new ArrayList<>();

        for(GeoResult<GeoLocation<String>> result : results) {
            Point point = geoOperations.position(DRIVER_GEO_OPS_KEY, result.getContent().getName()).get(0); // location of individual driver in redis
            DriverLocationDTO driverLocation = DriverLocationDTO.builder() // Note: Redis returns longitude as X and latitude as Y
            .driverId(result.getContent().getName())
            .latitude(point.getY())
            .longitude(point.getX())
            .build();
            driverLocations.add(driverLocation);
        }
        
        return driverLocations;
    }
}