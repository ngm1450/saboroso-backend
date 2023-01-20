package com.nicolas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EntityScan(basePackages = "com.nicolas.*")
@EnableJpaRepositories(basePackages = "com.nicolas.repository")
public class SaborosoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaborosoBackendApplication.class, args);
	}

}
