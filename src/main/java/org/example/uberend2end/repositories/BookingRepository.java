package org.example.uberend2end.repositories;

import org.example.uberend2end.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {

}
