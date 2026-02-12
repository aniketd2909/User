package org.example.uberend2end.entities;

import lombok.*;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "bookings")
public class Booking extends BaseEntity {

    private String passengerID;

    private String driverID;

    private double pickupLocationLatitude;

    private double pickupLocationLongtitude;

    private double dropOffLocationLatitude;

    private double dropOffLocationLongtitude;

    private BookingStatus bookingStatus;

    private Double fare;

}
