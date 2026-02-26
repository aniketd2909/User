package org.example.uberend2end.dtos;

import org.example.uberend2end.entities.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
