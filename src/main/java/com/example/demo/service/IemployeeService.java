package com.example.demo.service;

import com.example.demo.model.employeeModel;
import com.example.demo.service_3b.tables.pojos.Employee;

import java.util.List;

public interface IemployeeService {
 public void insertEmployee (employeeModel employee);
 public List<employeeModel> getAllEmployees();
 public void updateEmployee(employeeModel employee, String id);
 public void deleteEmployee(String id);
}
