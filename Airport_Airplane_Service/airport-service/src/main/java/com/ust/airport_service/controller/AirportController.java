package com.ust.airport_service.controller;

import com.ust.airport_service.entity.AirportEntity;
import com.ust.airport_service.model.AirplanePojo;
import com.ust.airport_service.model.AirportPojo;
import com.ust.airport_service.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/airports")
    public List<AirportPojo> getAllAirports(){
        return airportService.getAllAirports();
    }

    @GetMapping("/airports/{aid}")
    public Mono<AirportPojo> getAAirport(@PathVariable("aid") int airportId) {
        // Fetch the airport details
        AirportPojo airportPojo = airportService.getAAirport(airportId);

        // Use WebClient to fetch airplanes
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/api/airplanes/airports/" + airportId)
                .retrieve()
                .bodyToFlux(AirplanePojo.class) // Change List.class to AirplanePojo.class
                .collectList() // Collect results into a List
                .doOnNext(airportPojo::setAllAirplanes) // Set airplanes in airportPojo
                .then(Mono.just(airportPojo)); // Return airportPojo as a Mono
    }

    @PostMapping("/airports")
    public AirportPojo addAirport(@RequestBody AirportPojo airportPojo){
        return airportService.addAirport(airportPojo);
    }
}
