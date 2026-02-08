package org.example.uberend2end.repositories;

import org.example.uberend2end.entities.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends MongoRepository<Driver,String> {

}
