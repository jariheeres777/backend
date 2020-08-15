package com.example.demo.demo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InfoAnimals {
        @Id
        @GeneratedValue
        private Long animalID;
        private String species;
        private String animal;
        private String info;
        private String picture;


        public InfoAnimals() {
        }

        public InfoAnimals(String species) {
            this.animalID= animalID;
            this.species = species;
            this.animal = animal;
            this.info = info;
            this.picture =picture;

        }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public long getAnimalID() {
        return animalID;
    }

    public void setAnimalID(long animalID) {
        this.animalID = animalID;
    }
}
