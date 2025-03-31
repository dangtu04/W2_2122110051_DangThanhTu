package com.dangthanhtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dangthanhtu.backend.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
    Address findByCountryAndDistrictAndCityAndWardAndStreet(String country, String district, String city, String ward, String street);
}