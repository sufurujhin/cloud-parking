package com.daniel.ferreira.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.ferreira.controller.dto.ParkingCreateDTO;
import com.daniel.ferreira.controller.dto.ParkingDTO;
import com.daniel.ferreira.controller.mapper.ParkingMapper;
import com.daniel.ferreira.model.Parking;
import com.daniel.ferreira.service.ParkingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

	
	private final ParkingService parkingService;
	private final ParkingMapper parkingMapper;
	
	public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
		this.parkingService = parkingService;
		this.parkingMapper = parkingMapper;
	}

	@GetMapping
	@ApiOperation("Find all parkings")
	public ResponseEntity<List<ParkingDTO>> findAll() {
		List<Parking> parkingList = parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return ResponseEntity.ok().body(result);
	}
	@GetMapping("/{id}")
	@ApiOperation("Find by Id")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
		Parking parking = parkingService.findByID(id);
		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	@ApiOperation("Create parking")
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
		Parking parkingCreate = parkingMapper.toParkingCreate(dto);
		var parking = parkingService.create(parkingCreate);
		var result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
}
