package org.example.uberend2end.services;

import lombok.RequiredArgsConstructor;
import org.example.uberend2end.entities.Booking;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService {

    @Override
    public Booking createBooking(Booking booking) {
        return null;
    }

    @Override
    public Booking getBookingById(String bookingId) {
        return null;
    }

    @Override
    public Booking updateBookingStatus(String bookingId, String status) {
        return null;
    }

    @Override
    public void cancelBooking(String bookingId) {

    }

    @Override
    public Boolean acceptRide(Long bookingId, Long driverId) {
        return true;
    }

}
