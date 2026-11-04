package com.cifpcesarmanrique.ejercicio3animales.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AnimalNotFoundException extends Exception {
    public AnimalNotFoundException(String mensaje) {
        super(mensaje);
    }
}
