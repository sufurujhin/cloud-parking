package com.daniel.ferreira.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.daniel.ferreira.model.Parking;

@Service
public class ParkingService {

	private static Map<String , Parking> parkingMap = new HashMap<String , Parking>();
	
	static {
		String id  = getUUID();
		Parking parking1 = new Parking(id,"DMS-1111","SC","CELTA","PRETO");
		parkingMap.put(id,parking1);
		id  = getUUID();
		Parking parking2 = new Parking(id,"DMS-2222","AL","VW GOL","VERMELHO");
		parkingMap.put(id,parking2);
	}
	
	
	public List<Parking> findAll(){
		return parkingMap.values().stream().collect(Collectors.toList());
	}
	
	private static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public Parking findByID(String id) {
		return parkingMap.get(id);
	}

	public Parking create(Parking parkingCreate) {
		String id = getUUID();
		parkingCreate.setId(id);
		parkingCreate.setEntryDate(LocalDateTime.now());
		parkingMap.put(id, parkingCreate); 
		return parkingCreate;
	}
	
}
