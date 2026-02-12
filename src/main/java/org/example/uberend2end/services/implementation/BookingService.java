package org.example.uberend2end.services.implementation;

import java.util.List;

import org.example.uberend2end.client.GrpcClient;
import org.example.uberend2end.entities.Booking;
import org.example.uberend2end.entities.BookingStatus;
import org.example.uberend2end.repositories.BookingRepository;
import org.example.uberend2end.services.IBookingService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingService implements IBookingService {

    private final BookingRepository bookingRepository;
    private final GrpcClient grpcClient; // Inject gRPC Client

    @Override
    public Booking createBooking(Booking booking) {
        log.info("Booking Class Request {}", booking);
        Booking newBooking = Booking.builder()
                .passengerID(booking.getPassengerID())
                .driverID(booking.getDriverID())
                .pickupLocationLatitude(booking.getPickupLocationLatitude())
                .pickupLocationLongtitude(booking.getPickupLocationLongtitude())
                .dropOffLocationLatitude(booking.getDropOffLocationLatitude())
                .dropOffLocationLongtitude(booking.getDropOffLocationLongtitude())
                .bookingStatus(BookingStatus.PENDING)
                .fare(booking.getFare())
                .build();
        
        Booking savedBooking = bookingRepository.save(newBooking);

        // Notify Drivers via gRPC -> WebSocket
        // TODO: In real app, find nearby drivers. Here we notify dummy driver IDs [1, 2, 3]
        try {
            grpcClient.notifyDriversForNewRide(
                    savedBooking.getPickupLocationLatitude() + "",
                    savedBooking.getPickupLocationLongtitude() + "",
                    savedBooking.hashCode(), // Using hashcode as ID since Proto expects Int
                    List.of("698baa0116197481f1a56ebd".hashCode())
            );
        } catch (Exception e) {
            System.err.println("Failed to notify drivers via gRPC: " + e.getMessage());
        }
        return savedBooking;
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
