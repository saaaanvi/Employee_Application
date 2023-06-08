package com.example.demo.repository;

import com.example.demo.service_3b.tables.pojos.Employee;
import com.example.demo.service_3b.tables.pojos.Address;

import java.util.List;

public interface IEmployeeRepository {
 public void insertEmployee (Employee employee);
 public List<Employee> getAllEmployees();
 public void updateEmployee(Employee employee, String id);
 public void deleteEmployee(String id);



}
