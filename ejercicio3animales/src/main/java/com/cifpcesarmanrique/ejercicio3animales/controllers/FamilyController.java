package com.cifpcesarmanrique.ejercicio3animales.controllers;


import com.cifpcesarmanrique.ejercicio3animales.exceptions.FamilyNotFoundException;
import com.cifpcesarmanrique.ejercicio3animales.interfaces.FamilyService;
import com.cifpcesarmanrique.ejercicio3animales.models.Family;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class FamilyController {
    @Autowired
    private FamilyService fs;

    @GetMapping("/families")
    public String list(Model model) {
      model.addAttribute("families", fs.getFamilies());
      return "family/list";
    }

    @GetMapping("/families/details")
    public String details(@RequestParam("id") int id, Model model) throws FamilyNotFoundException {
        String response = "";
        try{
            Family family = fs.getFamily(id);
            model.addAttribute("family", family);
            response = "family/details";
        } catch (FamilyNotFoundException e){
            model.addAttribute("error", e.getMessage());
            response = "error/error";
        }

        return response;
    }

    @GetMapping("/families/create")
    public String createFamily(Model model) {
        Family family = new Family();
        model.addAttribute("family", new Family());
        return "family/create";
    }

    @PostMapping ("/families")
        public String createFamily(@Valid @ModelAttribute("family") Family family, BindingResult bindingResult, Model model){
        String response = null;
        if(bindingResult.hasErrors()){
            response = "family/create";
        } else {
            fs.addFamily(family);
            response = "redirect:/families";
        }

        return response;
    }

    @GetMapping ("/families/edit/{id}")
    public String editFamily(@PathVariable int id, Model model) throws FamilyNotFoundException {
        String response = "";
        try {
            Family family = fs.getFamily(id);
            model.addAttribute("family", family);
            return "family/edit";
        } catch (FamilyNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            response = "error/error";
        }

        return response;
    }

    @PostMapping ("/families/edit/{id}")
    public  String editFamily(@Valid @ModelAttribute("family") Family family, BindingResult bindingResult, Model model) throws FamilyNotFoundException {
        String response = null;
        try {
            if(bindingResult.hasErrors()){
                response = "family/edit";
            } else {
                fs.editFamily(family);
                response = "redirect:/families";
            }
        } catch (FamilyNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            response = "error/error";
        }

        return response;
    }

    @GetMapping ("/families/delete/{id}")
    public String showDeleteConfirmation(@PathVariable int id, Model model) throws FamilyNotFoundException {
        String response = "";
        try {
            Family family = fs.getFamily(id);
            model.addAttribute("family", family);
            response = "family/delete";
        } catch (FamilyNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            response = "error/error";
        }

        return response;
    }

    @PostMapping ("/families/delete/{id}")
    public String deleteFamily(@PathVariable int id, Model model) {
        boolean eliminado = fs.deleteFamily(id);
        return "redirect:/families";
    }
}
