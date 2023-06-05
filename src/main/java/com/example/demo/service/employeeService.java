package com.example.demo.service;

import com.example.demo.service_3b.Tables;
import com.example.demo.service_3b.tables.pojos.Employee;
import com.example.demo.service_3b.tables.records.EmployeeRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.repository.employeeRepository;
import org.springframework.beans.BeanUtils;

@Service
public class employeeService implements IemployeeService {

 @Autowired
 private employeeRepository empRep;


 public void insertEmployee (Employee employee) {
  empRep.insertEmployee(employee);
 }


 public List<Employee> getAllEmployees() {
  return empRep.getAllEmployees();
 }



 public void updateEmployee(Employee employee, int id) {
  empRep.updateEmployee(employee,id);

 }


 public void deleteEmployee(int id) {
  empRep.deleteEmployee(id);
 }
}
