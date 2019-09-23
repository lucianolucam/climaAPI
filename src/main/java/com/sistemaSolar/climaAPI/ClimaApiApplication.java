package com.sistemaSolar.climaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.sistemaSolar.climaAPI"})
@EnableJpaRepositories("com.sistemaSolar.climaAPI.rest.repositorio")
@EntityScan("com.sistemaSolar.climaAPI.domain.entidad")
public class ClimaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClimaApiApplication.class, args);
	}

}
