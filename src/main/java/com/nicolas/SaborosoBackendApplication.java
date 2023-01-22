package com.nicolas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaborosoBackendApplication {

	private static final Logger LOG = LogManager.getLogger(SaborosoBackendApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SaborosoBackendApplication.class, args);

		LOG.info("\n\n *** \n\n"
				+ "\tSABOROSO - BACKEND iniciado com sucesso!\n"
				+ "\tDisponivel no endereco:\n"
				+ "\tSwagger Url: http://localhost:8080/swagger-ui/index.html\n"
				+ "\n *** \n\n");

	}

}
