package com.azeem.key;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Repository;


@Repository
public class ProdDaoImpl implements ProductDao {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("product");

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            System.out.println(productEntity);
            entityManager.persist(productEntity);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            System.out.print("Error in save" + e.getMessage());
        } finally {
            entityManager.close();
        }

        return productEntity;
    }

    @Override
    public ProductEntity loadProduct(Integer productId) {
        ProductEntity productEntity = null;
        EntityManager entityManager = factory.createEntityManager();
        try {
            System.out.println("productId:" + productId);
            productEntity = entityManager.find(ProductEntity.class, productId);

            System.out.println("productEntity" + productEntity);
        } catch (Exception e) {
            System.out.println("Exception is loadprouct");
            entityManager.close();
        }

        return productEntity;
    }

    @Override
    public ProductEntity updateProduct(Integer productId, Double price) {
        EntityManager entityManager = factory.createEntityManager();
        ProductEntity productEntity = entityManager.find(ProductEntity.class, productId);
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            productEntity.setUnitPrice(price);
            entityManager.persist(productEntity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Exception in update");
        } finally {
            entityManager.close();
        }

        return productEntity;
    }


    @Override
    public void deleteProduct(Integer productId) {
        EntityManager entityManager = factory.createEntityManager();
        ProductEntity productEntity = entityManager.find(ProductEntity.class, productId);
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(productEntity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Exception in delete");
        } finally {
            entityManager.close();
        }
    }
}
