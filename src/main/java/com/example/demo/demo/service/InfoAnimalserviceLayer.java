package com.example.demo.demo.service;

import com.example.demo.demo.Repository.InfoAnimalsRepository;
import com.example.demo.demo.domain.InfoAnimals;
import com.example.demo.demo.exception.InfoAnimalsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InfoAnimalserviceLayer implements IinfoAnimalserviceLayer {

    @Autowired
    private InfoAnimalsRepository infoAnimalsRepository;


    @Override
    public InfoAnimals getInfoAnimals(Long animalID) {
        return infoAnimalsRepository.findById(animalID)
                .orElseThrow(() -> new InfoAnimalsNotFoundException(animalID));

    }

    @Override
    public InfoAnimals saveInfoAnimals(InfoAnimals newInfoAnimals) {
        return infoAnimalsRepository.save(newInfoAnimals);
    }

    @Override
    public InfoAnimals replaceInfoAnimals(InfoAnimals newInfoAnimals, Long animalID) {
        return infoAnimalsRepository.findById(animalID).map(InfoAnimals -> {
            InfoAnimals.setAnimal(newInfoAnimals.getAnimal());
            InfoAnimals.setInfo(newInfoAnimals.getInfo());
            InfoAnimals.setSpecies(newInfoAnimals.getSpecies());
            InfoAnimals.setPicture(newInfoAnimals.getPicture());
            return infoAnimalsRepository.save(InfoAnimals);
        }).orElseGet(() -> {
            newInfoAnimals.setAnimalID(animalID);
            return infoAnimalsRepository.save(newInfoAnimals);
        });
    }


    @Override
    public String deleteInfoAnimals(Long accountID) {
        return null;
    }
}



