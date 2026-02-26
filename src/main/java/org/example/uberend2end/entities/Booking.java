package org.example.uberend2end.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bookings")
public class Booking extends BaseEntity {

    @Column(name = "passenger_id", nullable = false)
    private String passengerID;

    @Column(name = "driver_id")
    private String driverID;

    @Column(name = "pickup_location_latitude", nullable = false)
    private double pickupLocationLatitude;

    @Column(name = "pickup_location_longitude", nullable = false)
    private double pickupLocationLongtitude;

    @Column(name = "dropoff_location_latitude", nullable = false)
    private double dropOffLocationLatitude;

    @Column(name = "dropoff_location_longitude", nullable = false)
    private double dropOffLocationLongtitude;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    private BookingStatus bookingStatus;

    @Column
    private Double fare;

}
