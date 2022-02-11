package com.project.gym;

import com.project.gym.controller.FelhasznaloResource;
import com.project.gym.model.Felhasznalo;
import com.project.gym.service.FelhasznaloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GymApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);

	}

}
