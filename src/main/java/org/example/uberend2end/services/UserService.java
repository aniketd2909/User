package org.example.uberend2end.services;

import lombok.*;
import org.example.uberend2end.adapter.UserMapper;
import org.example.uberend2end.dtos.UserDTO;
import org.example.uberend2end.entities.User;
import org.example.uberend2end.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = userRepository.save(UserMapper.toEntity(userDTO));
        return UserMapper.toUserDTO(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
