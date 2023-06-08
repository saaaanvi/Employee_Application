package com.example.demo.repository;

import com.example.demo.service_3b.tables.pojos.Address;

public interface IAddressRepository {
 public void insertAddress(Address address);
 public void updateAddress(Address address);
 public void deleteAddress(Address address);
 public Address getAddressByEmployeeId(String employeeId);
}
