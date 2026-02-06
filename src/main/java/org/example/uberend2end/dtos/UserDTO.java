package org.example.uberend2end.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime updatedAt;

}
