package com.daniel.ferreira;

import org.testcontainers.containers.PostgreSQLContainer;

public abstract class AbstractConteinerBase {

	static PostgreSQLContainer POSTGRE_SQL_CONTAINER = null;
	
	static {
		POSTGRE_SQL_CONTAINER = new PostgreSQLContainer("postgres:10-alpine");
		POSTGRE_SQL_CONTAINER.start();
		System.setProperty("spring.datasource.url",POSTGRE_SQL_CONTAINER.getJdbcUrl());
		System.setProperty("spring.datasource.username",POSTGRE_SQL_CONTAINER.getUsername());
		System.setProperty("spring.datasource.password",POSTGRE_SQL_CONTAINER.getPassword());
	}
}
