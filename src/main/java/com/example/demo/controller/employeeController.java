package com.example.demo.controller;

import com.example.demo.service.IemployeeService;
import com.example.demo.model.employeeModel;
import com.example.demo.service_3b.tables.pojos.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-profiles")
public class employeeController {

 @Autowired
 private IemployeeService service;

 @PostMapping
 public String addEmployee(@RequestBody employeeModel employee){
  service.insertEmployee(employee);
  return "Employee added";
 }

 @GetMapping
 public List<employeeModel> getEmployees(){
  return service.getAllEmployees();
 }

 @PutMapping("{id}")
 public String updateEmployee(@PathVariable String id,
   @RequestBody employeeModel employee) {
  service.updateEmployee(employee, id);
  return "Profile updated";
 }

 @DeleteMapping("{id}")
 public String deleteUser(@PathVariable String id) {
  service.deleteEmployee(id);
  return "Profile deleted";
 }

}
