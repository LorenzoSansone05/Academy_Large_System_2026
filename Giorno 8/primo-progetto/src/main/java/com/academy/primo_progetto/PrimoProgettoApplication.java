package com.academy.primo_progetto;

import com.academy.controller.SalutoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.academy.primo_progetto", "com.academy.controller", "com.academy.config"})
public class PrimoProgettoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimoProgettoApplication.class, args);
	}

}
