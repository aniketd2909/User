package org.example.uberend2end.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document(collection = "bookings")
public class Booking extends BaseEntity {

    @DBRef
    private Passenger passenger;

    @DBRef
    private Driver driver;

    private GeoJsonPoint pickupLocation;

    private GeoJsonPoint dropOffLocation;

    private BookingStatus bookingStatus;

    private Double fare;

}
