package com.nicolas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class SaborosoBackendApplication {

	private static final Logger LOG = LogManager.getLogger(SaborosoBackendApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(SaborosoBackendApplication.class, args);

		try {
			Environment env = ctx.getEnvironment();
			LOG.info("\n\n *** \n\n"
							+ "\tSABOROSO - BACKEND iniciado com sucesso!\n"
							+ "\tDisponivel nos enderecos:\n"
							+ "\tLocal: http://localhost:{}{}\n"
							+ "\tSwagger Url: http://localhost:{}{}/swagger-ui.html\n"
							+ "\tActuator: http://localhost:{}{}/actuator\n"
							+ "\n *** \n\n",
					env.getProperty("server.port"),
					env.getProperty("server.servlet.context-path"),

					InetAddress.getLocalHost().getHostAddress(),
					env.getProperty("server.port"),
					env.getProperty("server.servlet.context-path"),

					env.getProperty("server.port"),
					env.getProperty("server.servlet.context-path"));

		} catch (UnknownHostException e) {
			LOG.error("Falha ao executar aplicacao: {}", e);
			ctx.close();
		}
	}

}
