package com.cifpcesarmanrique.ejercicio3animales.interfaces;

import com.cifpcesarmanrique.ejercicio3animales.exceptions.AnimalNotFoundException;
import com.cifpcesarmanrique.ejercicio3animales.models.Animal;
import com.cifpcesarmanrique.ejercicio3animales.services.AnimalServiceMem;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public interface AnimalService {

        List<Animal> getAnimals();

        public Animal getAnimal(int id) throws AnimalNotFoundException;

        public Animal addAnimal(Animal a);

        public boolean deleteAnimal(int id);

        public Animal editAnimal(Animal animal) throws AnimalNotFoundException;



}