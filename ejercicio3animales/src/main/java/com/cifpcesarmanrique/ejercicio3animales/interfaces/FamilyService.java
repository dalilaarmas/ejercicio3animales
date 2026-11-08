package com.cifpcesarmanrique.ejercicio3animales.interfaces;

import com.cifpcesarmanrique.ejercicio3animales.exceptions.FamilyNotFoundException;
import com.cifpcesarmanrique.ejercicio3animales.models.Family;

import java.util.List;

public interface FamilyService {

    List<Family> getFamilies();

    public Family getFamily(int id) throws FamilyNotFoundException;

    public Family addFamily(Family f);

    public boolean deleteFamily(int id);

    public Family editFamily(Family family) throws FamilyNotFoundException;

}
