package org.example.uberend2end.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drivers")
@Getter
@Setter
public class Driver extends BaseEntity {

    @DBRef
    private User user;

    private Double rating;

    private Boolean available;

    private String vehicleId;

}
