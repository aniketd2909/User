package org.example.uberend2end.services;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.example.uberend2end.adapter.UserMapper;
import org.example.uberend2end.dtos.UserDTO;
import org.example.uberend2end.entities.User;
import org.example.uberend2end.repositories.UserRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;
    private static final String USER_KEY_PREFIX = "user:";
    private static final long USER_CACHE_TTL = 30;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = userRepository.save(UserMapper.toEntity(userDTO));
        return UserMapper.toUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::toUserDTO).toList();
    }

    @Override
    public UserDTO getUserById(String id) {
        log.info("Caching user with ID: {}", id);
        System.out.println("Caching user with ID: " + id);
        // Check if user exists in Redis cache
        String cachedUser = redisTemplate.opsForValue().get(USER_KEY_PREFIX + id);
        if (cachedUser != null) {
            return objectMapper.readValue(cachedUser, UserDTO.class);
        }
        UserDTO userDTO = UserMapper.toUserDTO(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
        // Cache user in Redis
        redisTemplate.opsForValue().set(USER_KEY_PREFIX + id, objectMapper.writeValueAsString(userDTO), USER_CACHE_TTL, TimeUnit.MINUTES);

        return userDTO;
    }

}
