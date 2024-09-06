package com.daitamer.Record.Shop.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RecordShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordShopApiApplication.class, args);
	}

}
