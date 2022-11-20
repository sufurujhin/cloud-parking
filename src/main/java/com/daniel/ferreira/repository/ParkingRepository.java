package com.daniel.ferreira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.ferreira.model.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {

}
