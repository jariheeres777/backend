package com.example.demo.demo.service;


import com.example.demo.demo.domain.Advertisement;

public interface IAdvertisementServiceLayer {

    Advertisement getAdvertisement(Long AdID);
    Advertisement saveAd(Advertisement newAd);
    String deleteAd(Long AdID);
    Advertisement replaceAD(Advertisement newAd, Long adID);
    Advertisement addAdToUserById(long userid, Advertisement newads);
}
