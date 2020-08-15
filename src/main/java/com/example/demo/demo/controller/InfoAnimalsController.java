package com.example.demo.demo.controller;
import com.example.demo.demo.domain.InfoAnimals;

import com.example.demo.demo.service.IinfoAnimalserviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InfoAnimalsController {
        @Autowired
        private IinfoAnimalserviceLayer iinfoAnimalserviceLayer;

        @GetMapping(value = "/api/InfoAnimals/{animalID}")
        public InfoAnimals getInfoAnimals(@PathVariable Long animalID) {
            return iinfoAnimalserviceLayer.getInfoAnimals(animalID);
        }

        @PostMapping(value = "/api/InfoAnimals")
        public InfoAnimals saveInfoAnimals(@RequestBody InfoAnimals newInfoAnimals) {
            return iinfoAnimalserviceLayer.saveInfoAnimals(newInfoAnimals);
        }


        @DeleteMapping(value = "/api/InfoAnimals/{animalID}")
        public String deleteInfoAnimals(@PathVariable Long animalID) {
            return iinfoAnimalserviceLayer.deleteInfoAnimals(animalID);
        }

        @PutMapping(value = "/api/InfoAnimals/{animalID}")
        public InfoAnimals replaceInfoAnimals(@RequestBody InfoAnimals newInfoAnimals, @PathVariable Long animalID) {
            return iinfoAnimalserviceLayer.replaceInfoAnimals(newInfoAnimals, animalID);
        }

}
