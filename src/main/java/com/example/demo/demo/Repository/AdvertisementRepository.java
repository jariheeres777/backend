package com.example.demo.demo.Repository;


import com.example.demo.demo.domain.Advertisement;
import org.springframework.data.repository.CrudRepository;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Long> {

}