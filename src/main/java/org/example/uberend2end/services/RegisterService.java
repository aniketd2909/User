package org.example.uberend2end.services;

import lombok.RequiredArgsConstructor;
import org.example.uberend2end.adapter.UserMapper;
import org.example.uberend2end.dtos.UserDTO;
import org.example.uberend2end.entities.User;
import org.example.uberend2end.exceptions.UserAlreadyPresentException;
import org.example.uberend2end.repositories.RegisterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService implements IRegisterService {

    private final RegisterRepository registerRepository;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        if (registerRepository.existsByEmail(userDTO.getEmail())) {
            throw new UserAlreadyPresentException("User with email " + userDTO.getEmail() + " already exists");
        }
        User user = UserMapper.toEntity(userDTO);
        return UserMapper.toUserDTO(registerRepository.save(user)); // Save the user and convert the saved entity back to DTO
    }
}
