package com.cifpcesarmanrique.ejercicio3animales;

import com.cifpcesarmanrique.ejercicio3animales.models.Animal;
import com.cifpcesarmanrique.ejercicio3animales.repositories.AnimalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio3animalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio3animalesApplication.class, args);
	}

	@Bean
    CommandLineRunner seedAnimals(AnimalRepository ar) {
		return (String[] args) -> {
			if (ar.count() == 0) {
				ar.save(new Animal(0, "Pidgeon", 58, false));
				ar.save(new Animal(0, "Rat", 5, false));
				ar.save(new Animal(0, "Rabbit", 5, false));
			}
		};
	}
}
