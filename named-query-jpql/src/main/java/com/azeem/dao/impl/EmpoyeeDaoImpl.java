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
    public List<EmployeeEntity> executeNamedQuery(Integer deptNo) {
        EntityManager entityManager = factory.createEntityManager();
        TypedQuery<EmployeeEntity> jpq = entityManager.createNamedQuery("query1", EmployeeEntity.class);
        jpq.setParameter(1, deptNo);
        List<EmployeeEntity> singleResult = jpq.getResultList();
        entityManager.close();
        return singleResult;
    }

    @Override
    public List<EmployeeEntity> executeNamedNativeQuery(Double sal) {
        EntityManager manager = factory.createEntityManager();
        Query jpq = manager.createNamedQuery("query2", EmployeeEntity.class);
        jpq.setParameter(1, sal);
        List<EmployeeEntity> resultList = jpq.getResultList();
        manager.close();
        return resultList;
    }

}
