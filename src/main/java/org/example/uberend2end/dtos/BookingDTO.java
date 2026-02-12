package org.example.uberend2end.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.uberend2end.entities.BookingStatus;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private String passengerID;

    private String driverID;

    private double pickupLocationLatitude;

    private double pickupLocationLongtitude;

    private double dropOffLocationLatitude;

    private double dropOffLocationLongtitude;

    private String id;

    private BookingStatus bookingStatus;

}
