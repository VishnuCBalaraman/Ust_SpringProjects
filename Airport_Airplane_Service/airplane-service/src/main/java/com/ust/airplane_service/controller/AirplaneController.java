package com.ust.airplane_service.controller;

import com.ust.airplane_service.entity.AirplaneEntity;
import com.ust.airplane_service.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirplaneController {

    @Autowired
    private AirplaneRepository airplaneRepo;

    @GetMapping("/airplanes")
    public List<AirplaneEntity> getAllAirplanes(){
        return airplaneRepo.findAll();
    }

    @GetMapping("/airplanes/{aid}")
    public AirplaneEntity getAAirplane(@PathVariable("aid") int airplaneId){
        return airplaneRepo.findById(airplaneId).orElse(null);
    }

    @PostMapping("/airplanes")
    public AirplaneEntity addAirplane(@RequestBody AirplaneEntity airplaneEntity){
        return airplaneRepo.saveAndFlush(airplaneEntity);
    }

    @GetMapping("/airplanes/airports/{aid}")
    public List<AirplaneEntity> getAirplanesByAirport(@PathVariable("aid") int aId){
        return airplaneRepo.findByAirplaneAirportId(aId);
    }
}
