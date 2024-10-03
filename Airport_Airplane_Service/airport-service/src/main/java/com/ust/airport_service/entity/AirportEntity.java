package com.ust.airport_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class AirportEntity {

    @Id
    private int airportId;
    private String airportName;
    private String airportLoc;
}
