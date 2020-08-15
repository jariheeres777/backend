package com.example.demo.demo.service.security;

import com.example.demo.demo.domain.Account;
import com.example.demo.demo.domain.InfoAnimals;

public interface IInfoAnimalserviceLayer {
    InfoAnimals replaceInfoAnimals(InfoAnimals newaccount, Long accountID);
    InfoAnimals saveInfoAnimals(InfoAnimals newInfoAnimals);
    InfoAnimals getInfoAnimals(Long accountID);
    String deleteInfoAnimals(Long accountID);
}
