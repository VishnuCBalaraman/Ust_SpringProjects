package com.ust.airport_service.service;

import com.ust.airport_service.entity.AirportEntity;
import com.ust.airport_service.model.AirportPojo;
import com.ust.airport_service.repository.AirportRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepo;

    public List<AirportPojo> getAllAirports(){
        List<AirportEntity> airportEntities = airportRepo.findAll();
        List<AirportPojo> airportPojos = new ArrayList<>();
        for(AirportEntity airportEntity: airportEntities){
            AirportPojo airportPojo = new AirportPojo();
            BeanUtils.copyProperties(airportEntity,airportPojo);
            airportPojos.add(airportPojo);
        }
        return airportPojos;
    }

    public AirportPojo getAAirport(int airportId){
        AirportEntity airportEntity = airportRepo.findById(airportId).orElse(null);
        AirportPojo airportPojo = null;
        if(airportEntity!=null){
            airportPojo = new AirportPojo();
            BeanUtils.copyProperties(airportEntity,airportPojo);
        }
        return airportPojo;
    }

    public AirportPojo addAirport(AirportPojo airportPojo){
        AirportEntity airportEntity = new AirportEntity();
        BeanUtils.copyProperties(airportPojo,airportEntity);
        airportRepo.saveAndFlush(airportEntity);
        return airportPojo;
    }
}
