package com.practice.restapisintercommunication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    @ApiModelProperty(notes = "Unique Id of the Employee")
    private int empId;

    @ApiModelProperty(notes = "Employee FirstName")
    @Column(name = "empFirstName")
    private String empFirstName;

    @Column(name = "empLastName")
    @ApiModelProperty(notes = "Employee LastName")
    private String empLastName;

    @Column(name = "salary")
    @ApiModelProperty(notes = "Employee Salary")
    private Float salary;

    public Employee() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Employee(int empId, String empFirstName, String empLastName, Float salary) {
        this.empId = empId;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.salary = salary;
    }
}
