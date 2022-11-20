package com.daniel.ferreira.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.ferreira.exception.ParkingNotFoundException;
import com.daniel.ferreira.model.Parking;
import com.daniel.ferreira.repository.ParkingRepository;

@Service
public class ParkingService {

	private final ParkingRepository parkingRepository;

	public ParkingService(ParkingRepository parkingRepository) {
		this.parkingRepository = parkingRepository;
	}

	@Transactional
	public List<Parking> findAll() {
		return parkingRepository.findAll();
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	@Transactional(readOnly = true)
	public Parking findByID(String id) {
		return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id, "Parking"));
	}

	@Transactional
	public Parking create(Parking parkingCreate) {
		String id = getUUID();
		parkingCreate.setId(id);
		parkingCreate.setEntryDate(LocalDateTime.now());
		parkingRepository.save(parkingCreate);
		return parkingCreate;
	}

	@Transactional
	public void delete(String id) {
		findByID(id);
		parkingRepository.deleteById(id);
	}

	@Transactional
	public Parking update(String id, Parking parkingCreateDTO) {
		var parking = findByID(id);
		parking.setColor(parkingCreateDTO.getColor());
		parking.setState(parkingCreateDTO.getState());
		parking.setModel(parkingCreateDTO.getModel());
		parking.setLicense(parkingCreateDTO.getLicense());
		parkingRepository.save(parking);
		return parking;
	}

	@Transactional
	public Parking checkOut(String id) {
		var parking = findByID(id);
		parking.setExitDate(LocalDateTime.now());
		parking.setBill(ParkingCheckOut.getBill(parking));
		parkingRepository.save(parking);
		return parking;
	}

}
