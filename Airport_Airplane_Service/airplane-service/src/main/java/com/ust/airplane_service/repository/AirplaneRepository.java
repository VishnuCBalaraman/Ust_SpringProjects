package com.ust.airplane_service.repository;

import com.ust.airplane_service.entity.AirplaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneRepository extends JpaRepository<AirplaneEntity,Integer> {
    List<AirplaneEntity> findByAirplaneAirportId(int aId);
}
