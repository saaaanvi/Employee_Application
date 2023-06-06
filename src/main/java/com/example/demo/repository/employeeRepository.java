package com.example.demo.repository;


import com.example.demo.service_3b.Tables;
import com.example.demo.service_3b.tables.pojos.Employee;
import com.example.demo.service_3b.tables.records.EmployeeRecord;
import org.jooq.DSLContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class employeeRepository implements IemployeeRepository {

  @Autowired
  private DSLContext dslContext;


  public void insertEmployee (Employee employee) {
   String id= java.util.UUID.randomUUID().toString();
   System.out.println(id);
   employee.setId(id);
   EmployeeRecord empRec= dslContext.newRecord(Tables.EMPLOYEE);
   empRec.from(employee);
   empRec.store();
  }


  public List<com.example.demo.service_3b.tables.pojos.Employee> getAllEmployees() {
   return dslContext.selectFrom(Tables.EMPLOYEE)
     .fetchInto(com.example.demo.service_3b.tables.pojos.Employee.class);
  }



  public void updateEmployee(Employee employee, String id) {
   EmployeeRecord employeeRecord = dslContext.newRecord(Tables.EMPLOYEE);
   BeanUtils.copyProperties(employee, employeeRecord);

   dslContext.update(Tables.EMPLOYEE)
     .set(employeeRecord)
     .where(Tables.EMPLOYEE.ID.eq(id))
     .execute();

  }


  public void deleteEmployee(String id) {
   dslContext.deleteFrom(Tables.EMPLOYEE)
     .where(Tables.EMPLOYEE.ID.eq(id))
     .execute();
  }
}
