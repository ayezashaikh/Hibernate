package com.azeem.composite.key;

import com.azeem.key.ProductDao;
import com.azeem.key.ProductEntity;
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

    @Override
    public void testEntitySets() {
        EntityManager manager = factory.createEntityManager();

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("test");
        productEntity.setProduct_id(1100);
        productEntity.setUnitPrice(100.25);

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(productEntity);   //persistent state
        transaction.commit();


        manager.find(ProductEntity.class,1100);//persistant state


        manager.detach(productEntity);
        productEntity.setQuantity(100);

        EntityTransaction t = manager.getTransaction();
        t.begin();
        manager.merge(productEntity);    // moved from detached state to persistent state
        t.commit();

        manager.close();











    }
}
