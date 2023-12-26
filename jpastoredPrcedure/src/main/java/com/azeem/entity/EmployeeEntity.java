package com.azeem.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table( name = "EMP" )
@NamedStoredProcedureQuery(name="pro1" , procedureName = "emp_experience",
        parameters = {
        @StoredProcedureParameter(mode=ParameterMode.IN, type=Integer.class, name="eno"),
        @StoredProcedureParameter(mode=ParameterMode.OUT, type=String.class, name="name"),
        @StoredProcedureParameter(mode=ParameterMode.OUT, type=Double.class, name="experience")
         }

)

public class EmployeeEntity implements Serializable {
    @Id
    @Column(name = "empno")
    private Integer employeeNumber;

    @Column(name = "ename")
    private String employeename;

    @Column(name = "SAL")
    private Double salary;

    @Column(name = "DEPTNO")
    private Integer deptNumber;

    public Integer getEmloyeeNumber() {
        return employeeNumber;
    }

    public void setEmloyeeNumber(Integer emloyeeNumber) {
        this.employeeNumber = emloyeeNumber;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(Integer deptNumber) {
        this.deptNumber = deptNumber;
    }

    public EmployeeEntity() {
    }
}
