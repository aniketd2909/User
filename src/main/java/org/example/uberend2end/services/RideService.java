package org.example.uberend2end.services;

import com.example.Uber.RideAcceptanceRequest;
import com.example.Uber.RideAcceptanceResponse;
import com.example.Uber.RideServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideService extends RideServiceGrpc.RideServiceImplBase {

    private final BookingService bookingService;

    @Override
    public void acceptRide(RideAcceptanceRequest request, StreamObserver<RideAcceptanceResponse> responseObserver) {
        // Call the BookingService to update the ride with the new driver id.
        Boolean success = bookingService.acceptRide(
                Long.parseLong("" + request.getBookingId()),
                Long.parseLong("" + request.getDriverId())
        );
        RideAcceptanceResponse response = RideAcceptanceResponse.newBuilder()
                .setSuccess(success)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
