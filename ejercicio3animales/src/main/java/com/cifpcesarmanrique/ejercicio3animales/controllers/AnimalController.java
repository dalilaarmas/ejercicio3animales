package com.cifpcesarmanrique.ejercicio3animales.controllers;

import com.cifpcesarmanrique.ejercicio3animales.exceptions.AnimalNotFoundException;
import com.cifpcesarmanrique.ejercicio3animales.models.Animal;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.cifpcesarmanrique.ejercicio3animales.interfaces.AnimalService;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService as;

    @GetMapping("/animals")
    public String list(Model model) {
        model.addAttribute("animals", as.getAnimals());
        return "list";
    }

    @GetMapping("/animals/details")
    public String details(@RequestParam("id") int id, Model model) throws AnimalNotFoundException {
        String response = "";
        try{
            Animal animal = as.getAnimal(id);
            model.addAttribute("animal", animal);
            response = "details";
        } catch (AnimalNotFoundException e){
            model.addAttribute("error", e.getMessage());
            response = "error/error";
        }

            return response;
    }

    @GetMapping("/animals/create")
    public String createAnimal(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", new Animal());
        return "create";
    }

    @PostMapping ("/animals")
        public String createAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult, Model model){
        String response = null;
        if(bindingResult.hasErrors()){
            response = "create";
        }else {
            as.addAnimal(animal);
            response = "redirect:/animals";
        }

        return response;
    }

    @GetMapping ("/animals/edit/{id}")
    public String editAnimal(@PathVariable int id, Model model) throws AnimalNotFoundException {
        String response = "";
        try {
            Animal animal = as.getAnimal(id);
            model.addAttribute("animal", animal);
            return "edit";
        }catch (AnimalNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            response = "error/error";
        }

        return response;
    }
    @PostMapping ("/animals/edit/{id}")
    public String editAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult, Model model) throws AnimalNotFoundException {
        String response = null;
        try{
            if(bindingResult.hasErrors()){
                response = "edit";
            }else {
                as.editAnimal(animal);
                response = "redirect:/animals";
            }
        } catch (AnimalNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            response = "error/error";
        }


        return response;
    }

    @GetMapping ("/animals/delete/{id}")
    public String showDeleteConfirmation(@PathVariable int id, Model model) throws AnimalNotFoundException {
        String response = "";
        try{
            Animal animal = as.getAnimal(id);
            model.addAttribute("animal", animal);
            response = "delete";
        } catch (AnimalNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            response = "error/error";
        }

        return response;
    }
    @PostMapping("/animals/delete/{id}")
    public String deleteAnimal(@PathVariable int id, Model model) {
            boolean eliminado = as.deleteAnimal(id);
            return "redirect:/animals";
    }
}