package com.example.demo.service;

import com.example.demo.model.AddressModel;
import com.example.demo.service_3b.tables.pojos.Address;

public interface IAddressService {
 public void insertAddress(AddressModel address, String id);
 public void updateAddress(AddressModel address, String id);
 public void deleteAddress(String employeeId);
 public AddressModel getAddressByEmployeeId(String employeeId);
}
