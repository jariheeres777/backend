package com.example.demo.demo.Repository;


import com.example.demo.demo.domain.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

}