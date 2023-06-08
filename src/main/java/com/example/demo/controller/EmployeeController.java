package com.example.demo.controller;

import com.example.demo.service.IAddressService;
import com.example.demo.service.IEmployeeService;
import com.example.demo.model.EmployeeModel;
import com.example.demo.model.AddressModel;
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
public class EmployeeController {

 @Autowired
 private IEmployeeService employeeService;


 @PostMapping
 public String addEmployee(@RequestBody EmployeeModel employee){
  employeeService.insertEmployee(employee);
  return "Employee added";
 }


 @GetMapping
 public List<EmployeeModel> getEmployees(){
  return employeeService.getAllEmployees();
 }

 @PutMapping("{id}")
 public String updateEmployee(@PathVariable String id,
   @RequestBody EmployeeModel employee) {
  employeeService.updateEmployee(employee, id);
  return "Profile updated";
 }


 @DeleteMapping("{id}")
 public String deleteUser(@PathVariable String id) {
  employeeService.deleteEmployee(id);
  return "Profile deleted";
 }


}
