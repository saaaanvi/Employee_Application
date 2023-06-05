package com.example.demo.service;

import com.example.demo.service_3b.tables.pojos.Employee;

import java.util.List;

public interface IemployeeService {
 public void insertEmployee (Employee employee);
 public List<Employee> getAllEmployees();
 public void updateEmployee(Employee employee, int id);
 public void deleteEmployee(int id);
}
