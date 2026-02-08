package org.example.uberend2end.services.onboarding;

import lombok.RequiredArgsConstructor;
import org.example.uberend2end.entities.Role;
import org.example.uberend2end.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserProfileFactory {

    private final List<IProfileCreator> profileCreators;

    public void createProfiles(User user) {
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            return;
        }

        for (Role role : user.getRoles()) {
            for (IProfileCreator creator : profileCreators) {
                if (creator.supports(role)) {
                    creator.createProfile(user);
                }
            }
        }
    }
}
