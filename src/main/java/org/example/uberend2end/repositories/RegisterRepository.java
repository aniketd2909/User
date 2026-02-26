package org.example.uberend2end.repositories;

import org.example.uberend2end.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<User, String> {

    boolean existsByEmail(String email);

}
