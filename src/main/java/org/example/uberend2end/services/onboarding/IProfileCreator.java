package org.example.uberend2end.services.onboarding;

import org.example.uberend2end.entities.Role;
import org.example.uberend2end.entities.User;

public interface IProfileCreator {
    boolean supports(Role role);
    void createProfile(User user);
}
