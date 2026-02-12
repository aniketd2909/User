package org.example.uberend2end.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverNotificationDTO {

    private String pickUpLocationLatitude;
    private String pickUpLocationLongitude;
    private Integer bookingId;

}
