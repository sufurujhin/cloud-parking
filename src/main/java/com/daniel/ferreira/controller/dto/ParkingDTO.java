package com.daniel.ferreira.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

//JsonInclude remove os campos nulo do json.
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ParkingDTO {

	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private Double bill;
}
