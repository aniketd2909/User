package org.example.uberend2end.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer extends  BaseEntity {

    @DBRef
    private User user; // Reference to the User entity

    private Double rating;

}
