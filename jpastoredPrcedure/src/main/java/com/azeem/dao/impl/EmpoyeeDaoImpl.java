package com.azeem.dao.impl;

import com.azeem.constant.AppConstant;
import com.azeem.dao.EmployeeDao;
import com.azeem.entity.EmployeeEntity;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpoyeeDaoImpl implements EmployeeDao {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");


    @Override
    public void executeStoredProcedure(int empno) {
        EntityManager manager = factory.createEntityManager();
        StoredProcedureQuery query = manager.createNamedStoredProcedureQuery("pro1");

        EntityTransaction entityTransaction = manager.getTransaction();
         entityTransaction.begin();
        query.setParameter("eno", empno);
        query.execute();

        String name = (String) query.getOutputParameterValue("name");
        double experience = (Double) query.getOutputParameterValue("experience");
        System.out.println("name" + name);
        System.out.println("experience" + experience);
        entityTransaction.commit();
        manager.close();

    }
}
