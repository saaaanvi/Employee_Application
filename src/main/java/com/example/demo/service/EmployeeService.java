package com.example.demo.service;

import com.example.demo.exception.RecordsNotFoundException;
import com.example.demo.model.AddressModel;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service_3b.tables.pojos.Address;
import com.example.demo.service_3b.tables.pojos.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

 @Autowired
 private EmployeeRepository empRep;

 @Autowired
 private AddressService addService;

 public void insertEmployee(EmployeeModel employeeModel) {
  Employee employee = new Employee();
  BeanUtils.copyProperties(employeeModel, employee);

  String employeeId = java.util.UUID.randomUUID().toString();
  employee.setId(employeeId);
  employeeModel.setAddressModel(employeeModel.getAddressModel());
  empRep.insertEmployee(employee);
  addService.insertAddress(employeeModel.getAddressModel(), employeeId);
 }

 public List<EmployeeModel> getAllEmployees() {
  List<Employee> employees = empRep.getAllEmployees();
  if (employees.isEmpty()) {
   throw new RecordsNotFoundException("No employees found in the database.");
  }

  List<EmployeeModel> employeeModels = new ArrayList<>();
  for (Employee employee : employees) {
   EmployeeModel employeeModel = new EmployeeModel();
   BeanUtils.copyProperties(employee, employeeModel);

   AddressModel addressModel = addService.getAddressByEmployeeId(employee.getId());
   if (addressModel == null) {
    throw new RecordsNotFoundException("Address not found for employeeId: " + employee.getId());
   }

   employeeModel.setAddressModel(addressModel);
   employeeModels.add(employeeModel);
  }
  return employeeModels;
 }

 public void updateEmployee(EmployeeModel employeeModel, String id) {
  Employee existingEmployee = empRep.getEmployeeById(id);
  if (existingEmployee == null) {
   throw new RecordsNotFoundException("Employee not found for id: " + id);
  }

  Employee updatedEmployee = new Employee();
  BeanUtils.copyProperties(employeeModel, updatedEmployee);
  empRep.updateEmployee(updatedEmployee, id);
 }

 public void deleteEmployee(String id) {
  Employee existingEmployee = empRep.getEmployeeById(id);
  if (existingEmployee == null) {
   throw new RecordsNotFoundException("Employee not found for id: " + id);
  }

  addService.deleteAddress(id);
  empRep.deleteEmployee(id);
 }

 public EmployeeModel getEmployeeById(String id) {
  Employee employee = empRep.getEmployeeById(id);
  if (employee == null) {
   throw new RecordsNotFoundException("Employee not found for id: " + id);
  }

  EmployeeModel employeeModel = new EmployeeModel();
  BeanUtils.copyProperties(employee, employeeModel);

  AddressModel addressModel = addService.getAddressByEmployeeId(employee.getId());
  if (addressModel == null) {
   throw new RecordsNotFoundException("Address not found for employeeId: " + employee.getId());
  }

  employeeModel.setAddressModel(addressModel);
  return employeeModel;
 }
}
