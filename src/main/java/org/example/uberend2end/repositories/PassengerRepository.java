package org.example.uberend2end.repositories;

import org.example.uberend2end.entities.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends MongoRepository<Passenger, String>{
}
