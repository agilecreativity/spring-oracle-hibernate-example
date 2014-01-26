package com.demo.example;

import java.sql.Date;

public class Employee {

  private Long employeeId;

  private String firstName;

  private String lastName;

  private Date birthDate;

  private String cellPhone;

  private Department department;

  public Employee() {}

  public Employee(String firstName, String lastName, Date birthdate, String cellPhone) {
    this.firstName = firstName;
    this.lastName = lastName;
    birthDate = birthdate;
    this.cellPhone = cellPhone;
  }

  public Employee(String firstName, String lastName, String cellPhone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.cellPhone = cellPhone;
  }

  @Override
  public boolean equals(Object emp) {
    if (emp instanceof Employee) {
      final Employee employee = (Employee) emp;

      if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName()))
        return true;
    }

    return false;
  }

  @Override
  public int hashCode() {

    return firstName.hashCode() + lastName.hashCode();
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getCellPhone() {
    return cellPhone;
  }

  public void setCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

}
