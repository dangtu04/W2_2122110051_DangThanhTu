package com.dangthanhtu.backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangthanhtu.backend.entity.Address;
import com.dangthanhtu.backend.entity.User;
import com.dangthanhtu.backend.exceptions.APIException;
import com.dangthanhtu.backend.exceptions.ResourceNotFoundException;
import com.dangthanhtu.backend.payloads.AddressDTO;
import com.dangthanhtu.backend.repository.AddressRepo;
import com.dangthanhtu.backend.repository.UserRepo;
import com.dangthanhtu.backend.service.AddressService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class AddressServiceImpl implements AddressService {
  @Autowired
  private AddressRepo addressRepo;
  @Autowired
  private UserRepo userRepo;
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public AddressDTO createAddress(AddressDTO addressDTO) {
    String country = addressDTO.getCountry();
    String district = addressDTO.getDistrict();
    String city = addressDTO.getCity();
    String ward = addressDTO.getWard();
    String street = addressDTO.getStreet();
    Address addressFromDB = addressRepo.findByCountryAndDistrictAndCityAndWardAndStreet(country, district, city, ward, street);
    if (addressFromDB != null) {
      throw new APIException("Address already exists with addressId:" + addressFromDB.getAddressId());
    }
    Address address = modelMapper.map(addressDTO, Address.class);
    Address savedAddress = addressRepo.save(address);
    return modelMapper.map(savedAddress, AddressDTO.class);
  }

  @Override
  public List<AddressDTO> getAddresses() {
    List<Address> addresses = addressRepo.findAll();
    List<AddressDTO> addressDTOS = addresses.stream().map(address -> modelMapper.map(address, AddressDTO.class))
        .collect(Collectors.toList());
    return addressDTOS;
  }

  @Override
  public AddressDTO getAddress(Long addressId) {
    Address address = addressRepo.findById(addressId)
        .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));
    return modelMapper.map(address, AddressDTO.class);
  }

  @Override
  public AddressDTO updateAddress(Long addressId, Address address) {
    Address addressFromDB = addressRepo.findByCountryAndDistrictAndCityAndWardAndStreet(
        address.getCountry(), address.getDistrict(), address.getCity(), address.getWard(), address.getStreet());

    if (addressFromDB == null) {
      addressFromDB = addressRepo.findById(addressId)
          .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));
      addressFromDB.setCountry(address.getCountry());
      addressFromDB.setDistrict(address.getDistrict());
      addressFromDB.setWard(address.getWard());
      addressFromDB.setStreet(address.getStreet());
      addressFromDB.setCity(address.getCity());
      Address updatedAddress = addressRepo.save(addressFromDB);
      return modelMapper.map(updatedAddress, AddressDTO.class);
    } else {
      List<User> users = userRepo.findByAddress(addressId);
      final Address a = addressFromDB;
      users.forEach(user -> user.getAddresses().add(a));
      deleteAddress(addressId);
      return modelMapper.map(addressFromDB, AddressDTO.class);
    }
  }

  @Override
  public String deleteAddress(Long addressId) {
    Address addressFromDB = addressRepo.findById(addressId)
        .orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId));
    List<User> users = userRepo.findByAddress(addressId);
    users.forEach(user -> {
      user.getAddresses().remove(addressFromDB);
      userRepo.save(user);
    });
    addressRepo.deleteById(addressId);
    return "Address deleted succesfully with addressId: " + addressId;
  }
}