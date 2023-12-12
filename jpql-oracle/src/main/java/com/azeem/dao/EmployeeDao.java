package com.azeem.dao;

import com.azeem.entity.EmployeeEntity;

import java.util.List;
import java.util.Objects;

public interface EmployeeDao {

    EmployeeEntity fetchEmployeeById(Integer empno);

    List<EmployeeEntity> fetchEmployees();

    List<Object[]> fetchNameAndSalaries();
}
