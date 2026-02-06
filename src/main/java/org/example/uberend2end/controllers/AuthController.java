package org.example.uberend2end.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.uberend2end.adapter.UserMapper;
import org.example.uberend2end.dtos.LoginUserDTO;
import org.example.uberend2end.dtos.RegisterUserDTO;
import org.example.uberend2end.dtos.UserDTO;
import org.example.uberend2end.dtos.UserResponseDTO;
import org.example.uberend2end.services.RegisterService;
import org.example.uberend2end.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final RegisterService registerService;

    @PostMapping("/login")
            public ResponseEntity<?> loginUser(LoginUserDTO loginUserDTO) {
                log.info("Login attempt for user with email: {}", loginUserDTO);
        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
        log.info("Registering user with email: {}", registerUserDTO.getEmail());
        UserDTO userDTO = registerService.registerUser(UserMapper.toUserDTO(registerUserDTO));
        return ResponseEntity.ok(UserMapper.toUserResponseDTO(userDTO));

    }
}
