package com.example.demo.demo.service;


import com.example.demo.demo.Repository.AccountRepository;
import com.example.demo.demo.Repository.AdvertisementRepository;
import com.example.demo.demo.domain.Account;
import com.example.demo.demo.domain.Advertisement;
import com.example.demo.demo.exception.AdvertisementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
public class AdvertisementServiceLayer implements IAdvertisementServiceLayer {

    @Autowired
    private AdvertisementRepository AdvertisementRepository;
    @Autowired
    private AccountRepository AccountRepository;


    @Override
    public Advertisement getAdvertisement(Long AdID) {
        return AdvertisementRepository.findById(AdID)
                .orElseThrow(() -> new AdvertisementNotFoundException(AdID));
    }

    @Override
    public Advertisement saveAd(@RequestBody Advertisement newAd) {
        return AdvertisementRepository.save(newAd);
    }

    @Override
    public String deleteAd(@PathVariable Long AdID) {
        Optional<Advertisement> Advertisement = AdvertisementRepository.findById(AdID);
        if (Advertisement.isPresent()) {
            AdvertisementRepository.deleteById(AdID);
            return "ad with " + Advertisement.get().getAdID() + "is deleted";
        } else {
            throw new AdvertisementNotFoundException("Hallo, ik besta niet");
        }
    }

    @Override
    public Advertisement replaceAD(@RequestBody Advertisement newAd, @PathVariable Long AdID) {
        return AdvertisementRepository.findById(AdID).map(Advertisement -> {
            Advertisement.setAdname(newAd.getAdname());
            Advertisement.setPricead(newAd.getPricead());
            Advertisement.setAdtext(newAd.getAdtext());
            Advertisement.setAdPictures(newAd.getAdPictures());
            return AdvertisementRepository.save(Advertisement);
        }).orElseGet(() -> {
            newAd.setAdID(AdID);
            return AdvertisementRepository.save(newAd);
        });
    }

    @Override
    public Advertisement addAdToUserById(@PathVariable long userid,
                                         @RequestBody Advertisement newads) {

        Optional<Account> user =
                AccountRepository.findById(userid);
        if (user.isPresent()) {
            newads.setUser(user.get());
            return AdvertisementRepository.save(newads);
        }

        throw new AdvertisementNotFoundException(userid);
    }
}
