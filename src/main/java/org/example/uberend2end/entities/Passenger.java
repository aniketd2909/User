package org.example.uberend2end.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passengers")
@Getter
@Setter
public class Passenger extends BaseEntity {

    private String userId; // Decoupled reference to User ID

    private Double rating;

    private GeoJsonPoint currentLocation;

}
