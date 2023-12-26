package com.azeem.dao;

import com.azeem.entity.EmployeeEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface EmployeeDao {

    void executeStoredProcedure(int empno);

}
