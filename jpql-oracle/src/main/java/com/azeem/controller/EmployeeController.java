package com.azeem.controller;

import com.azeem.dao.EmployeeDao;
import com.azeem.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/employee/{id}")
    EmployeeEntity fetchEmployeeById(@PathVariable("id") Integer empno) {
        return employeeDao.fetchEmployeeById(empno);
    }

    @GetMapping("/employee")
    List<EmployeeEntity> fetchEmployees() {
        return employeeDao.fetchEmployees();
    }

    @GetMapping("/employee/name/salary")
    List<Object[]> fetchNameAndSalaries() {
        return employeeDao.fetchNameAndSalaries();
    }
}
