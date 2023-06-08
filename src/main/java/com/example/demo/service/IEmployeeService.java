package com.example.demo.service;

import com.example.demo.model.AddressModel;
import com.example.demo.model.EmployeeModel;
import com.example.demo.service_3b.tables.pojos.Address;

import java.util.List;

public interface IEmployeeService {
 public void insertEmployee (EmployeeModel employee);
 public List<EmployeeModel> getAllEmployees();
 public void updateEmployee(EmployeeModel employee, String id);
 public void deleteEmployee(String id);

}
