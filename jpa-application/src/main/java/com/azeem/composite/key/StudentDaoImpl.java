package com.azeem.composite.key;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;

@Service
public class StudentDaoImpl implements StudentDao {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("product");
    @Override
    public Student saveStudent(Student student) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        return student;

    }

    @Override
    public Student fetchStudent(StudentCompositeKey compositeKey) {
        EntityManager entityManager = factory.createEntityManager();
        Student student = entityManager.find(Student.class, compositeKey);
        return student;
    }
}
