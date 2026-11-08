package com.cifpcesarmanrique.ejercicio3animales.services;

import com.cifpcesarmanrique.ejercicio3animales.exceptions.AnimalNotFoundException;
import com.cifpcesarmanrique.ejercicio3animales.interfaces.AnimalService;
import com.cifpcesarmanrique.ejercicio3animales.models.Animal;
import com.cifpcesarmanrique.ejercicio3animales.models.Family;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    // @Primary
    @Service
    public class AnimalServiceMem implements AnimalService {
        private List<Animal> animals = new ArrayList<>(Arrays.asList(new Animal(1, "Dodo", 58, true, new Family(1,"Birds")), new Animal(2, "Hen", 5, false, new Family(1,"Birds")),new Animal(3, "Ladybug", 2, false, new Family(2,"Insects"))));
        private int animalsCount = 3;

        public List<Animal> getAnimals() {
            return animals;
        }

        public Animal getAnimal(int id) throws AnimalNotFoundException {

            for (Animal animal : animals) {
                if (animal.getId() == id) {
                    return animal;
                }
            }
            throw new AnimalNotFoundException("Animal not found");

        }

        public Animal addAnimal(Animal a) {
            animalsCount++;
            a.setId(animalsCount);
            animals.add(a);
            return a;
        }

        public boolean deleteAnimal(int id) {
            int index = 0;
            boolean encontrado = false;

            while (index < animals.size() && !encontrado) {
                if(animals.get(index).getId() == id) {
                    encontrado = true;
                } else {
                    index++;
                }
            }

            if (encontrado) {
                animals.remove(index);
            }

            return encontrado;
        }

        public Animal editAnimal(Animal updatedAnimal) throws AnimalNotFoundException {
            int index = 0;
            boolean encontrado = false;
            Animal animal = null;

            while (index < animals.size() && !encontrado) {
                if(animals.get(index).getId() == updatedAnimal.getId()) {
                    encontrado = true;
                } else {
                    index++;
                }
            }

            if (encontrado) {

                animals.get(index).setName(updatedAnimal.getName());
                animals.get(index).setAverageLifespan(updatedAnimal.getAverageLifespan());
                animals.get(index).setExtinct(updatedAnimal.isExtinct());
                animal = animals.get(index);
            }

            if(!encontrado) {
                throw new AnimalNotFoundException("Animal not found");
            }
            return animal;
        }
    }


