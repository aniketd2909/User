package org.example.uberend2end.repositories;

import org.example.uberend2end.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,String> {

}
