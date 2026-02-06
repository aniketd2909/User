package org.example.uberend2end.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.uberend2end.entities.Address;
import org.example.uberend2end.entities.Role;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDTO {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;

}
