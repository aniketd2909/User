package org.example.uberend2end.controllers;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        log.info("Caching user with ID: {}", id);
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

}
