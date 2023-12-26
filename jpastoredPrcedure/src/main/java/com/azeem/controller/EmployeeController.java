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

    @GetMapping("/execute")
  void executeProcedure(){
      employeeDao.executeStoredProcedure(7839);
  }

}