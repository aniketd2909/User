package org.example.uberend2end.dtos;

import java.util.Set;

import org.example.uberend2end.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDTO {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Set<Role> roles;

}
