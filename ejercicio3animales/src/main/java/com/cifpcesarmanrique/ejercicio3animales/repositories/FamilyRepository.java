package com.cifpcesarmanrique.ejercicio3animales.repositories;

import com.cifpcesarmanrique.ejercicio3animales.models.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Integer> {
}
