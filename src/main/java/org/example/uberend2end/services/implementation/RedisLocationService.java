package org.example.uberend2end.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.example.uberend2end.dtos.DriverLocationDTO;
import org.example.uberend2end.services.ILocationService;
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
public class RedisLocationService implements ILocationService {

    private static final String DRIVER_GEO_OPS_KEY = "driver:geo"; // represent location of driver entity in redis

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public Boolean saveDriverLocation(String driverId, Double latitude, Double longitude) {

        GeoOperations<String, String> geoOperations = stringRedisTemplate.opsForGeo();
        // Redis GEO commands expect longitude first, then latitude
        geoOperations.add(DRIVER_GEO_OPS_KEY, 
            new RedisGeoCommands.GeoLocation<>(driverId, new Point(latitude, longitude))
        );
        log.info("Driver location saved, {}", driverId);
        return true;
    }

    @Override
    public List<DriverLocationDTO> getNearbyDrivers(Double latitude, Double longitude, Double radius) {
        GeoOperations<String, String> geoOperations = stringRedisTemplate.opsForGeo();

        Distance circleRadius = new Distance(radius, Metrics.KILOMETERS);

        Circle circle = new Circle(new Point(latitude, longitude), circleRadius);

        GeoResults<GeoLocation<String>> results = geoOperations.radius(DRIVER_GEO_OPS_KEY, circle); // query redis

        List<DriverLocationDTO> driverLocations = new ArrayList<>();

        for(GeoResult<GeoLocation<String>> result : results) {

            Point point = geoOperations.position(DRIVER_GEO_OPS_KEY, result.getContent().getName()).get(0); // Redis returns longitude as X and latitude as Y
            
            DriverLocationDTO driverLocation = DriverLocationDTO.builder()
            .driverId(result.getContent().getName())
            .latitude(point.getY())
            .longitude(point.getX())
            .build();

            driverLocations.add(driverLocation);
        }
        
        return driverLocations;
    }

}
