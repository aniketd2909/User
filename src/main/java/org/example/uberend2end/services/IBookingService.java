package org.example.uberend2end.services;

import org.example.uberend2end.entities.Booking;

public interface IBookingService {

    // Method to create a new booking
    Booking createBooking(Booking booking);
    // Method to get booking details by ID
    Booking getBookingById(String bookingId);
    // Method to update booking status
    Booking updateBookingStatus(String bookingId, String status);
    // Method to cancel a booking
    void cancelBooking(String bookingId);

    Boolean acceptRide(Long bookingId, Long driverId);

}
