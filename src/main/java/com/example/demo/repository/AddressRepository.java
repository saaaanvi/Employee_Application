package com.example.demo.repository;

import com.example.demo.service_3b.Tables;
import com.example.demo.service_3b.tables.pojos.Address;
import com.example.demo.service_3b.tables.records.AddressRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepository implements IAddressRepository {

 @Autowired
 private DSLContext dslContext;

 @Override
 public void insertAddress(Address address) {
  AddressRecord addressRecord = dslContext.newRecord(Tables.ADDRESS);
  addressRecord.from(address);
  addressRecord.store();
 }

 @Override
 public void updateAddress(Address address) {
  AddressRecord addressRecord = dslContext.newRecord(Tables.ADDRESS);
  addressRecord.from(address);
  addressRecord.update();
 }

 @Override
 public void deleteAddress(Address address) {
  dslContext.deleteFrom(Tables.ADDRESS)
    .where(Tables.ADDRESS.EMPLOYEE_ID.eq(address.getEmployeeId()))
    .execute();
 }

 @Override
 public Address getAddressByEmployeeId(String employeeId) {
  return dslContext.selectFrom(Tables.ADDRESS)
    .where(Tables.ADDRESS.EMPLOYEE_ID.eq(employeeId))
    .fetchOneInto(Address.class);
 }
}
