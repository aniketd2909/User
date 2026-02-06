package org.example.uberend2end.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.example.uberend2end.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
