package com.ust.airport_service.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AirportPojo {
    private int airportId;
    private String airportName;
    private String airportLoc;

    private List<AirplanePojo> allAirplanes;
}
