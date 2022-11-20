package com.daniel.ferreira.controller.dto;

import lombok.Data;

@Data
public class ParkingCreateDTO {

	private String license;
	private String state;
	private String model;
	private String color;
}
