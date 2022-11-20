package com.daniel.ferreira.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends RuntimeException {

	public ParkingNotFoundException(String id, String nameClasse) {
		super(nameClasse + " not found with id: " + id);
	}
}
