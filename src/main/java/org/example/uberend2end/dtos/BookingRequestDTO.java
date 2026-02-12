package org.example.uberend2end.dtos;

import lombok.*;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDTO {

    private String passengerID;

    private String driverID;

    private double pickupLocationLatitude;

    private double pickupLocationLongtitude;

    private double dropOffLocationLatitude;

    private double dropOffLocationLongtitude;

}
