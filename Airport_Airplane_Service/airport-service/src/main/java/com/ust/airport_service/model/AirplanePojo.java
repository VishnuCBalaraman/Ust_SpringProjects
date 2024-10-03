package com.ust.airport_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AirplanePojo {
    private int airplaneId;
    private String airplaneName;
    private String source;
    private String destination;

    private int airplaneAirportId;
}
