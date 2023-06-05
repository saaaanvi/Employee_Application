package com.example.demo.repository;

import com.example.demo.service.IemployeeService;
import com.example.demo.service_3b.Tables;
import com.example.demo.service_3b.tables.pojos.Employee;
import com.example.demo.service_3b.tables.records.EmployeeRecord;
import org.jooq.DSLContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public class employeeRepository implements IemployeeRepository {

  @Autowired
  private DSLContext dslContext;


  public void insertEmployee (com.example.demo.service_3b.tables.pojos.Employee employee) {
   dslContext.insertInto(Tables.EMPLOYEE, Tables.EMPLOYEE.ID, Tables.EMPLOYEE.FIRST_NAME,
       Tables.EMPLOYEE.LAST_NAME, Tables.EMPLOYEE.EMAIL, Tables.EMPLOYEE.PHONE_NUMBER,
       Tables.EMPLOYEE.SALARY, Tables.EMPLOYEE.HIRE_DATE, Tables.EMPLOYEE.DEPARTMENT)
     .values(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(),
       employee.getPhoneNumber(), employee.getSalary(), employee.getHireDate(),
       employee.getDepartment()).execute();
  }


  public List<com.example.demo.service_3b.tables.pojos.Employee> getAllEmployees() {
   return dslContext.selectFrom(Tables.EMPLOYEE)
     .fetchInto(com.example.demo.service_3b.tables.pojos.Employee.class);
  }



  public void updateEmployee(Employee employee, int id) {
   EmployeeRecord employeeRecord = dslContext.newRecord(Tables.EMPLOYEE);

   // Copy properties from the UserProfile object to the UserProfileRecord
   BeanUtils.copyProperties(employee, employeeRecord);

   dslContext.update(Tables.EMPLOYEE)
     .set(employeeRecord)
     .where(Tables.EMPLOYEE.ID.eq(id))
     .execute();

  }


  public void deleteEmployee(int id) {
   dslContext.deleteFrom(Tables.EMPLOYEE)
     .where(Tables.EMPLOYEE.ID.eq(id))
     .execute();
  }
}
