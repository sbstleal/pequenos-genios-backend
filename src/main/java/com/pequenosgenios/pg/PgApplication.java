package com.pequenosgenios.pg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PgApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Estou funcionando");
	}
}
