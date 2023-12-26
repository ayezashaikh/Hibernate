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


    @Override
    public List<EmployeeEntity> executeCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = factory.createEntityManager().getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> query = criteriaBuilder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> root = query.from(EmployeeEntity.class);
        //  query.select(root).where(criteriaBuilder.gt(root.get("salary"), 2000));

        query.select(root).where(criteriaBuilder.and(criteriaBuilder.gt(root.get("salary"), 3000),
                criteriaBuilder.lt(root.get("salary"), 6000)));

        Query q = factory.createEntityManager().createQuery(query);

        List resultList = q.getResultList();
        return resultList;


    }
}
