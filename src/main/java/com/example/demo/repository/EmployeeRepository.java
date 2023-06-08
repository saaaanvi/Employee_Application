package com.example.demo.repository;


import com.example.demo.service_3b.Tables;
import com.example.demo.service_3b.tables.pojos.Address;
import com.example.demo.service_3b.tables.pojos.Employee;
import com.example.demo.service_3b.tables.records.AddressRecord;
import com.example.demo.service_3b.tables.records.EmployeeRecord;
import org.jooq.DSLContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

  @Autowired
  private DSLContext dslContext;


  public void insertEmployee (Employee employee) {
   EmployeeRecord empRec= dslContext.newRecord(Tables.EMPLOYEE);
   empRec.from(employee);
   empRec.store();
  }


  public List<com.example.demo.service_3b.tables.pojos.Employee> getAllEmployees() {
   return dslContext.selectFrom(Tables.EMPLOYEE)
     .fetchInto(com.example.demo.service_3b.tables.pojos.Employee.class);
  }



  public void updateEmployee(Employee employee, String id) {
   EmployeeRecord employeeRecord = dslContext.fetchOne(Tables.EMPLOYEE, Tables.EMPLOYEE.ID.eq(id));

   if (employeeRecord != null) {
    employeeRecord.from(employee);
    employeeRecord.store();
   }
  }


  public void deleteEmployee(String id) {
   dslContext.deleteFrom(Tables.EMPLOYEE)
     .where(Tables.EMPLOYEE.ID.eq(id))
     .execute();
  }

}
