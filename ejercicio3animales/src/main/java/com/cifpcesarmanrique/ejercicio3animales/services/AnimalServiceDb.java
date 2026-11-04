package com.cifpcesarmanrique.ejercicio3animales.services;

import com.cifpcesarmanrique.ejercicio3animales.exceptions.AnimalNotFoundException;
import com.cifpcesarmanrique.ejercicio3animales.interfaces.AnimalService;
import com.cifpcesarmanrique.ejercicio3animales.models.Animal;
import com.cifpcesarmanrique.ejercicio3animales.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

//@Primary
@Service
public class AnimalServiceDb implements AnimalService {

    @Autowired
    AnimalRepository ar;

    public List<Animal> getAnimals() {
        return ar.findAll();
    }

    public Animal getAnimal(int id) throws AnimalNotFoundException {

        return ar.findById(id)
                .orElseThrow(()-> new AnimalNotFoundException("Animal not found"));
    }

    public Animal addAnimal(Animal a) {
        return ar.save(a);
    }

    public boolean deleteAnimal(int id) {
        boolean exists = false;

        if (ar.existsById(id)) {
            exists = true;
            ar.deleteById(id);
        }
        return exists;
    }

    public Animal editAnimal(Animal animal) throws AnimalNotFoundException {
        getAnimal(animal.getId());

        return ar.save(animal);

    }
}