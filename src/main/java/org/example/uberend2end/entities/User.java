package org.example.uberend2end.entities;

import jakarta.validation.constraints.*;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "users")
@Builder
public class User extends BaseEntity {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    private String password;

    private String phoneNumber;

    private String profilePicture;

    private Address address;

    private Role role; // This is the role of the user, e.g., DRIVER, RIDER, ADMIN

    private GeoJsonPoint currentLocation;

}
