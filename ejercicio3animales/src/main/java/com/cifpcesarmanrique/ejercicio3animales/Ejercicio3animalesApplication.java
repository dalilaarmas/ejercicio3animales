package com.cifpcesarmanrique.ejercicio3animales;

import com.cifpcesarmanrique.ejercicio3animales.models.Animal;
import com.cifpcesarmanrique.ejercicio3animales.models.Family;
import com.cifpcesarmanrique.ejercicio3animales.repositories.AnimalRepository;
import com.cifpcesarmanrique.ejercicio3animales.repositories.FamilyRepository;
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
	CommandLineRunner initData(FamilyRepository fr, AnimalRepository ar) {
		return args -> {

			if (fr.count() == 0) {
				Family mammals = fr.save(new Family(0, "Mammals"));
				Family birds = fr.save(new Family(0, "Birds"));
				Family reptiles = fr.save(new Family(0, "Reptiles"));
				Family insects = fr.save(new Family(0, "Insects"));

				ar.save(new Animal(0, "Pidgeon", 58, false, birds));
				ar.save(new Animal(0, "Rat", 5, false, mammals));
				ar.save(new Animal(0, "Rabbit", 5, false, mammals));
			}
		};
	}


}