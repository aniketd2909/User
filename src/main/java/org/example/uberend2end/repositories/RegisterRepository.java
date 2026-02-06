package org.example.uberend2end.repositories;

import org.example.uberend2end.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisterRepository extends MongoRepository<User, String> {

    boolean existsByEmail(String email);

}
