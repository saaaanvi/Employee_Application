package com.example.demo.service;

import com.example.demo.model.employeeModel;
import com.example.demo.repository.employeeRepository;
import com.example.demo.service_3b.tables.pojos.Employee;
import com.example.demo.service_3b.tables.records.EmployeeRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.repository.employeeRepository;

@Service
public class employeeService implements IemployeeService {

 @Autowired
 private employeeRepository empRep;


 public void insertEmployee (employeeModel employeeModel) {
  Employee employee = new Employee();
  BeanUtils.copyProperties(employeeModel, employee);
  empRep.insertEmployee(employee);
 }

 public List<employeeModel> getAllEmployees() {
  List<Employee> employees = empRep.getAllEmployees();
  List<employeeModel> employeeModels = new ArrayList<>();
  for (Employee employee : employees) {
   employeeModel employeeModel = new employeeModel();
   BeanUtils.copyProperties(employee, employeeModel);
   employeeModels.add(employeeModel);
  }
  return employeeModels;
 }

 public void updateEmployee(employeeModel employeeModel, String id) {

  Employee employee = new Employee();
  BeanUtils.copyProperties(employeeModel, employee);
  empRep.updateEmployee(employee,id);

 }


 public void deleteEmployee(String id) {
  empRep.deleteEmployee(id);
 }
}
