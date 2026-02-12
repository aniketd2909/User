package org.example.uberend2end.adapter;

import org.example.uberend2end.dtos.BookingDTO;
import org.example.uberend2end.dtos.BookingRequestDTO;
import org.example.uberend2end.dtos.BookingResponseDTO;
import org.example.uberend2end.entities.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public static BookingResponseDTO toBookingResponseDTO(BookingDTO bookingDTO) {
        return BookingResponseDTO.builder()
                .id(bookingDTO.getId())
                .bookingStatus(bookingDTO.getBookingStatus())
                .build();
    }

    public static BookingDTO toBookingDTO(Booking booking) {
        return BookingDTO.builder()
                .passengerID(booking.getPassengerID())
                .driverID(booking.getDriverID())
                .pickupLocationLatitude(booking.getPickupLocationLatitude())
                .pickupLocationLongtitude(booking.getPickupLocationLongtitude())
                .dropOffLocationLatitude(booking.getDropOffLocationLatitude())
                .dropOffLocationLongtitude(booking.getDropOffLocationLongtitude())
                .bookingStatus(booking.getBookingStatus())
                .id(booking.getId())
                .build();
    }

    public static BookingDTO toBookingDTO(BookingRequestDTO bookingRequestDTO) {
        return BookingDTO.builder()
                .passengerID(bookingRequestDTO.getPassengerID())
                .pickupLocationLatitude(bookingRequestDTO.getPickupLocationLatitude())
                .pickupLocationLongtitude(bookingRequestDTO.getPickupLocationLongtitude())
                .dropOffLocationLatitude(bookingRequestDTO.getDropOffLocationLatitude())
                .dropOffLocationLongtitude(bookingRequestDTO.getDropOffLocationLongtitude())
                .build();
    }

    public static Booking toEntity(BookingDTO bookingDTO) {
        return Booking.builder()
                .passengerID(bookingDTO.getPassengerID())
                .driverID(bookingDTO.getDriverID())
                .pickupLocationLatitude(bookingDTO.getPickupLocationLatitude())
                .pickupLocationLongtitude(bookingDTO.getPickupLocationLongtitude())
                .dropOffLocationLatitude(bookingDTO.getDropOffLocationLatitude())
                .dropOffLocationLongtitude(bookingDTO.getDropOffLocationLongtitude())
                .bookingStatus(bookingDTO.getBookingStatus())
                .build();
    }

}
