package com.example.demo.repository;

import com.example.demo.model.employeeModel;
import com.example.demo.service_3b.tables.pojos.Employee;

import java.util.List;

public interface IemployeeRepository{
 public void insertEmployee (Employee employee);
 public List<Employee> getAllEmployees();
 public void updateEmployee(Employee employee, String id);
 public void deleteEmployee(String id);
}
