package org.example.uberend2end.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
