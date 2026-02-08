package org.example.uberend2end.repositories;

import org.example.uberend2end.entities.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {

}
