package org.example.uberend2end.services.implementation;

import java.util.Set;

import org.example.uberend2end.entities.Role;
import org.example.uberend2end.entities.User;
import org.example.uberend2end.repositories.UserRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserMcpService {
    // This service can be used for any MCP related operations for User, such as syncing user data with external systems, etc.
    // For now, it's just a placeholder to demonstrate separation of concerns and potential future expansion.
    private final UserRepository userRepository;

    // The @Tool annotation exposes this method to the AI Client.
    // The description is crucial—it tells the AI *when* to use this tool.
    @Tool(description = "Create a new user in the system. Use this when the user asks to onboard someone or create an account.")
    public User createUser(String firstName, String email, Set<Role> roles) {
        // Notice: No AI parsing logic here! 
        // The AI Client (Claude) has already done the work of extracting "Alice", "Smith", etc.
        User newUser = User.builder()
                .name(firstName)
                .email(email)
                .roles(roles)
                .build();
        return userRepository.save(newUser);
    }

}
