package com.cifpcesarmanrique.ejercicio3animales.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
@Entity
public class Animal {
    @NotNull(message = "Id cannot be null")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 15, message = "Name must be between 3 and 15 characters")
    private String name;
    @NotNull(message = "Average lifespan cannot be null")
    @Min(value = 0, message = "Average lifespan must be at least 0")
    @Max(value = 600, message = "Average lifespan cannot exceed 600")
    private int averageLifespan;

    private boolean extinct;

    public Animal(){}
    public Animal(int id, String name, int averageLifespan, boolean extinct){
        this.id = id;
        this.name = name;
        this.averageLifespan = averageLifespan;
        this.extinct = extinct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(int averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public boolean isExtinct() {
        return extinct;
    }

    public void setExtinct(boolean extinct) {
        this.extinct = extinct;
    }
}
