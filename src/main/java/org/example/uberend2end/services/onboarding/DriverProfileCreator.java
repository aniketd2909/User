package org.example.uberend2end.services.onboarding;

import lombok.RequiredArgsConstructor;
import org.example.uberend2end.entities.Driver;
import org.example.uberend2end.entities.Role;
import org.example.uberend2end.entities.User;
import org.example.uberend2end.repositories.DriverRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DriverProfileCreator implements IProfileCreator {

    private final DriverRepository driverRepository;

    @Override
    public boolean supports(Role role) {
        return role == Role.DRIVER;
    }

    @Override
    public void createProfile(User user) {
        Driver driver = new Driver();
        driver.setUserId(user.getId());
        driver.setAvailable(false);
        driver.setRating(0.0);
        driverRepository.save(driver);
    }
}
