package org.example.uberend2end.dtos;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDTO {

    private String pickUpLocationLatitude;
    private String pickUpLocationLongitude;
    private Integer bookingId;
    private java.util.List<Integer> driverIds;

}
