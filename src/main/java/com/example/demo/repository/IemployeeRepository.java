package com.example.demo.repository;

import com.example.demo.service_3b.tables.pojos.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IemployeeRepository{
 public void insertEmployee (com.example.demo.service_3b.tables.pojos.Employee employee);
 public List<Employee> getAllEmployees();
 public void updateEmployee(Employee employee, int id);
 public void deleteEmployee(int id);
}
