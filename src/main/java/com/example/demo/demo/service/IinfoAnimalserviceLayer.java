package com.example.demo.demo.service;

import com.example.demo.demo.domain.InfoAnimals;

public interface IinfoAnimalserviceLayer {

    InfoAnimals getInfoAnimals(Long animalID);
    InfoAnimals replaceInfoAnimals(InfoAnimals newInfoAnimals, Long animalID);
    InfoAnimals saveInfoAnimals(InfoAnimals newInfoAnimals);
    String deleteInfoAnimals(Long animalID);

}
