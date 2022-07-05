package com.olmez.ceilingfan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CeilingfanApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CeilingfanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("*** CeilingFan application has started! **");
		// TODO
		log.info("*** The database connection is not configured! ***");
	}

}
