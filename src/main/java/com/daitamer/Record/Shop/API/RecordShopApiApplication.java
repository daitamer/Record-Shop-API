package com.daitamer.Record.Shop.API;
//import io.swagger.v3.oas.models.*;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class RecordShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordShopApiApplication.class, args);
	}

//	@Bean
//	public OpenAPI recordShopAPI(){
//		return new OpenAPI()
//				.info(new Info().title("Record Shop API")
//						.description("Welcome to the Record Shop API")
//						.version("v1")
//						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
//				)
//	}

}
