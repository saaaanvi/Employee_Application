package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class employeeModel {
 private String id;
 private String firstName;
 private String lastName;
 private String email;
 private String phoneNumber;
 private String hireDate;
 private Integer salary;
 private String department;
}
