package com.astralife.rest.endpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = { "com.astralife.rest" })
@EnableJpaRepositories(basePackages = "com.astralife.rest.persistence.repository")
@EnableTransactionManagement
@EntityScan(basePackages = "com.astralife.rest.persistence.model")
public class AstralifeStarter extends SpringBootServletInitializer{

	private final static  Logger log = LogManager.getLogger(AstralifeStarter.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AstralifeStarter.class);
	}

	public static void main(String[] args) {
		log.info("ASTRA LIFE REST UP");
		SpringApplication.run(AstralifeStarter.class, args);
	}
}
