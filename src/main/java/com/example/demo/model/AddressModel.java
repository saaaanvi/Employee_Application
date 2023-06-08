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
public class AddressModel {
 private String street;
 private String city;
 private String state;
 private String postalCode;
 private String employeeId;
}
