package org.example.uberend2end.controllers;

import lombok.RequiredArgsConstructor;

import org.example.uberend2end.adapter.UserMapper;
import org.example.uberend2end.dtos.UserDTO;
import org.example.uberend2end.dtos.UserRequestDTO;
import org.example.uberend2end.dtos.UserResponseDTO;
import org.example.uberend2end.entities.User;
import org.example.uberend2end.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserDTO userDTO = userService.registerUser(UserMapper.toUserDTO(userRequestDTO));
        UserResponseDTO userResponseDTO = UserMapper.toUserResponseDTO(userDTO);
        return ResponseEntity.status(201).body(userResponseDTO);
    }

}
