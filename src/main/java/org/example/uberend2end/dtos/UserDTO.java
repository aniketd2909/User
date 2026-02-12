package org.example.uberend2end.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.uberend2end.entities.Role;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private Set<Role> roles;
    private LocalDateTime updatedAt;

}
