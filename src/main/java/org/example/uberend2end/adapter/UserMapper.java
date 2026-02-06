package org.example.uberend2end.adapter;

import org.example.uberend2end.dtos.UserDTO;
import org.example.uberend2end.dtos.UserRequestDTO;
import org.example.uberend2end.dtos.UserResponseDTO;
import org.example.uberend2end.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toEntity(UserDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .build();
    }

    public static UserResponseDTO toUserResponseDTO(UserDTO userDTO) {
        return UserResponseDTO.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .lastModifiedDate(userDTO.getUpdatedAt())
                .build();
    }

    public static UserDTO toUserDTO(UserRequestDTO userRequestDTO) {
        return UserDTO.builder()
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getEmail())
                .build();
    }

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

}
