package com.ust.airplane_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class AirplaneEntity {

    @Id
    private int airplaneId;
    private String airplaneName;
    private String source;
    private String destination;

    private int airplaneAirportId;
}
