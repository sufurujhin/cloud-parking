package com.daniel.ferreira;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.daniel.ferreira.controller.dto.ParkingCreateDTO;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerTest {

	@LocalServerPort
	private int randomPort;

	@BeforeEach
	public void setUpTest() {
		RestAssured.port = randomPort;
	}

	@Test
	void whenFindAllThenCheckResult() {
		RestAssured.given().when().get("/parking").then().statusCode(201).body("license[0]",
				Matchers.equalTo("DMS-1111"));
	}

	@Test
	void whenFindAllThenCheckCreated() {
		
		var createDTO = new ParkingCreateDTO();
		createDTO.setColor("AMARELO");
		createDTO.setLicense("WRT-5555");
		createDTO.setModel("BRASILIA");
		createDTO.setState("SL");
		
		RestAssured.given()
		.when()
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.post("/parking")
		.then()
		.statusCode(HttpStatus.CREATED.value())
		.body("license", Matchers.equalTo("DMS-1111"))
		.body("color", Matchers.equalTo("AZUL"));
	}

}
