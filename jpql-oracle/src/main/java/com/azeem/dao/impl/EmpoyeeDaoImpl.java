package com.azeem.dao.impl;

import com.azeem.constant.AppConstant;
import com.azeem.dao.EmployeeDao;
import com.azeem.entity.EmployeeEntity;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpoyeeDaoImpl implements EmployeeDao {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

    @Override
    public EmployeeEntity fetchEmployeeById(Integer empno) {
        EntityManager entityManager = factory.createEntityManager();
        TypedQuery<EmployeeEntity> jpq = entityManager.createQuery(AppConstant.QUERY1, EmployeeEntity.class);
        jpq.setParameter(1, empno);
        EmployeeEntity singleResult = jpq.getSingleResult();
        entityManager.close();
        return singleResult;
    }

    @Override
    public List<EmployeeEntity> fetchEmployees() {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<EmployeeEntity> jpq = manager.createQuery(AppConstant.QUERY2, EmployeeEntity.class);
        List<EmployeeEntity> resultList = jpq.getResultList();
        manager.close();
        return resultList;
    }

    @Override
    public List<Object[]> fetchNameAndSalaries() {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Object[]> jpq = manager.createQuery(AppConstant.QUERY3, Object[].class);
        List<Object[]> list = jpq.getResultList();
        manager.close();
        return list;
    }
}
