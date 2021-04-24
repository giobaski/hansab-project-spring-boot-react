package com.hansab.carsrestapi;

import com.hansab.carsrestapi.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class CarsRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsRestApiApplication.class, args);
	}

}
