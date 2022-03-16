package com.project.gym;

import com.project.gym.model.Felhasznalo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class GymApplication {

	//TODO: Security & authentication

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);

	}
}
