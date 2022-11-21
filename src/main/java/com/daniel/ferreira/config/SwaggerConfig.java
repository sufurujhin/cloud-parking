package com.daniel.ferreira.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  
	private Contact contato() {
		return new Contact("Daniel F","https://www.linkedin.com/in/daniel-ferreira-bba820109","daniel_pato@hotmail.com");
	}
	
	private ApiInfoBuilder informacoesApi() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("Parking Rest API");
		apiInfoBuilder.description("Spring boot API for Parking");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
		apiInfoBuilder.license("Apache License Version 3.0");
		apiInfoBuilder.licenseUrl("https://www.linkedin.com/in/daniel-ferreira-bba820109");
		apiInfoBuilder.contact(this.contato());
		return apiInfoBuilder;
		
	}
	
	
	private List<SecurityScheme> basicScheme(){
		List<SecurityScheme> schemeList = new ArrayList<>();
		schemeList.add(new BasicAuth("basicAuth"));
		return schemeList;
	}
	
	private SecurityScheme basicAuthSchme() {
		// TODO Auto-generated method stub
		return new BasicAuth("basicAuth");
	}

	private SecurityContext getSecurityContext() {
		return SecurityContext.builder().securityReferences(Arrays.asList(basicAuthReference())).build();
	}
	
	private SecurityReference basicAuthReference() {
		// TODO Auto-generated method stub
		return new SecurityReference("basicAuth", new AuthorizationScope[0]);
	}

	@Bean
	public Docket detalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.daniel.ferreira.controller"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build())
		.consumes(new HashSet<String>(Arrays.asList("application/json")))
		.produces(new HashSet<String>(Arrays.asList("application/json")))
		.securityContexts(Arrays.asList(getSecurityContext()))
		.securitySchemes(Arrays.asList(basicAuthSchme()));
		return docket;
	}

}
