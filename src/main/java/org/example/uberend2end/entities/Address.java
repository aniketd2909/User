package org.example.uberend2end.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Column(name = "address_line")
    private String addressLine;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

}
