package com.daniel.ferreira.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Parking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private Double bill;

	public Parking(String id, String license, String state, String model, String color) {
		this.id = id;
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;
	}

	public Parking() {

	}
	
}
