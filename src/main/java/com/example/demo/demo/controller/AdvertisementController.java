package com.example.demo.demo.controller;



import com.example.demo.demo.domain.Advertisement;
import com.example.demo.demo.service.IAdvertisementServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdvertisementController {
    @Autowired
    private IAdvertisementServiceLayer AdvertisementServiceLayer;

    @GetMapping(value = "/api/Advertisement/{AdID}")
    public Advertisement getAdvertisement(@PathVariable Long AdID) {
        return AdvertisementServiceLayer.getAdvertisement(AdID);
    }

    @PostMapping(value = "/api/Advertisement")
    public Advertisement saveAd(@RequestBody Advertisement newAd) {
        return AdvertisementServiceLayer.saveAd(newAd);
    }

    @DeleteMapping(value = "/api/Advertisement/{AdID}")
    public String deleteAd(@PathVariable Long AdID) {
        return AdvertisementServiceLayer.deleteAd(AdID);}

    @PutMapping(value = "/api/Advertisement/{AdID}")
    public Advertisement replaceAD(@RequestBody Advertisement newAd, @PathVariable Long AdID) {
        return AdvertisementServiceLayer.replaceAD(newAd,AdID);
    }

    @PostMapping(value = "/api/Advertisement/{userid}")
    public Advertisement addAdToUserById(@PathVariable long userid,
                                @RequestBody Advertisement newads) {
        return AdvertisementServiceLayer.addAdToUserById(userid,newads);
    }

}
