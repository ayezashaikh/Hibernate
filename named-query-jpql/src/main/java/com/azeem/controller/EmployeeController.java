package com.azeem.controller;

import com.azeem.dao.EmployeeDao;
import com.azeem.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/employee/{deptNo}")
    List<EmployeeEntity> fetchEmployeeById(@PathVariable("deptNo") Integer deptNo) {
        return employeeDao.executeNamedQuery(deptNo);
    }

    @GetMapping("/employee/sal/{sal}")
    List<EmployeeEntity> fetchEmployees(@PathVariable("sal") Double sal) {
        return employeeDao.executeNamedNativeQuery(sal);
    }


    @GetMapping("/criteria-query")
    public List<EmployeeEntity> executeCriteriaQuery() {
        return employeeDao.executeCriteriaQuery();
    }
}