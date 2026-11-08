package com.cifpcesarmanrique.ejercicio3animales.services;

import com.cifpcesarmanrique.ejercicio3animales.exceptions.FamilyNotFoundException;
import com.cifpcesarmanrique.ejercicio3animales.interfaces.FamilyService;
import com.cifpcesarmanrique.ejercicio3animales.models.Family;
import com.cifpcesarmanrique.ejercicio3animales.repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceDb implements FamilyService {

    @Autowired
    FamilyRepository fr;

    public List<Family> getFamilies() {return fr.findAll();}

    public Family getFamily(int id) throws FamilyNotFoundException {
        return fr.findById(id)
                .orElseThrow(()-> new FamilyNotFoundException("Family not found"));
    }

    public Family addFamily(Family f) {return fr.save(f);}

    public boolean deleteFamily(int id) {
        boolean exists = false;

        if (fr.existsById(id)) {
            exists = true;
            fr.deleteById(id);
        }

        return exists;
    }

    public Family editFamily (Family family) throws FamilyNotFoundException {
        getFamily(family.getId());

        return fr.save(family);
    }

}
