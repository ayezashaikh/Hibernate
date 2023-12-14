package com.azeem.dao;

import com.azeem.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDao {

    List<EmployeeEntity> executeNamedQuery(Integer deptNo);

    List<EmployeeEntity> executeNamedNativeQuery(Double sal);

}
