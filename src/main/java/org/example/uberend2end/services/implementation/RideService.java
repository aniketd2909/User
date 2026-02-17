package org.example.uberend2end.services.implementation;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;

import com.example.Uber.RideAcceptanceRequest;
import com.example.Uber.RideAcceptanceResponse;
import com.example.Uber.RideServiceGrpc;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RideService extends RideServiceGrpc.RideServiceImplBase {

    private final BookingService bookingService;

    private final ReentrantLock rideAcceptanceLock = new ReentrantLock();

    @Override
    public void acceptRide(RideAcceptanceRequest request, StreamObserver<RideAcceptanceResponse> responseObserver) {
        log.info("acceptRide start: {}", request);
        rideAcceptanceLock.lock(); // Acquire the lock
        try {
            // Call the BookingService to update the ride with the new driver id.
            Boolean success = bookingService.acceptRide(request.getBookingId(), request.getDriverId());
            RideAcceptanceResponse response = RideAcceptanceResponse.newBuilder()
                    .setSuccess(success)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } finally {
            rideAcceptanceLock.unlock(); // Ensure the lock is always released
            log.info("acceptRide end: {}", request);
        }
    }

}
