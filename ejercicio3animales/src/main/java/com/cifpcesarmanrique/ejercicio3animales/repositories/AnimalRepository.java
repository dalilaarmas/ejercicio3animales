package com.cifpcesarmanrique.ejercicio3animales.repositories;

import com.cifpcesarmanrique.ejercicio3animales.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{
}
