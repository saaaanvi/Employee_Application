package com.example.demo.service;

import com.example.demo.exception.RecordsNotFoundException;
import com.example.demo.model.AddressModel;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service_3b.tables.pojos.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {

 @Autowired
 private AddressRepository addressRepository;

 @Override
 public void insertAddress(AddressModel addressModel, String employeeId) {
  Address address = new Address();
  BeanUtils.copyProperties(addressModel, address);
  address.setEmployeeId(employeeId);
  addressRepository.insertAddress(address);
 }

 @Override
 public void updateAddress(AddressModel addressModel, String employeeId) {
  Address address = addressRepository.getAddressByEmployeeId(employeeId);
  if (address == null) {
   throw new RecordsNotFoundException("Address not found for employeeId: " + employeeId);
  }
  BeanUtils.copyProperties(addressModel, address);
  addressRepository.updateAddress(address);
 }

 @Override
 public void deleteAddress(String employeeId) {
  Address address = addressRepository.getAddressByEmployeeId(employeeId);
  if (address == null) {
   throw new RecordsNotFoundException("Address not found for employeeId: " + employeeId);
  }
  addressRepository.deleteAddress(address);
 }

 @Override
 public AddressModel getAddressByEmployeeId(String employeeId) {
  Address address = addressRepository.getAddressByEmployeeId(employeeId);
  if (address == null) {
   throw new RecordsNotFoundException("Address not found for employeeId: " + employeeId);
  }
  AddressModel addressModel = new AddressModel();
  BeanUtils.copyProperties(address, addressModel);
  return addressModel;
 }
}
