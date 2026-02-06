package org.example.uberend2end.services;

import org.example.uberend2end.dtos.UserDTO;
import org.example.uberend2end.entities.User;
import java.util.List;

public interface IUserService {

    UserDTO registerUser(UserDTO userDTO); // This method registers a new user.

    List<User> getAllUsers();

}
