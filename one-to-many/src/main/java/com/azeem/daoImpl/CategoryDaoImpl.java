package com.azeem.daoImpl;

import com.azeem.CategoryDao;
import com.azeem.entity.CategoriesEntity;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Service
public class CategoryDaoImpl implements CategoryDao {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

    @Override
    public void saveCategory(CategoriesEntity categoriesEntity) {

        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(categoriesEntity);
            transaction.commit();
            System.out.println("persisted successfully");
        } catch (Exception e) {
            System.out.println("erorr"+e.getMessage());
            transaction.rollback();
        } finally {
            entityManager.close();
        }


    }

    @Override
    public CategoriesEntity fetchCtegory(Integer categoryId) {

        EntityManager manager = factory.createEntityManager();

        CategoriesEntity categoriesEntity = manager.find(CategoriesEntity.class, categoryId);

        manager.close();
        return categoriesEntity;
    }

    @Override
    public void removeCategory(Integer categoryId) {

        EntityManager entityManager = factory.createEntityManager();

        CategoriesEntity categoriesEntity = entityManager.find(CategoriesEntity.class, categoryId);

        EntityTransaction transaction = entityManager.getTransaction();

      try {
          transaction.begin();
          entityManager.refresh(categoriesEntity);
          transaction.commit();

          entityManager.close();
          System.out.println("deleetd successfullly");
      }
      catch(Exception e){
          System.out.println(e.getMessage());
      }
      finally {
          entityManager.close();
      }
    }
}
