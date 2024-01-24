package com.azeem.daoImpl;

import com.azeem.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;


@Service
public class BookDaoImpl implements BookDao {


    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

    @Override
    public void saveBook(Book book) {

        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        System.out.println(book);
        transaction.begin();
        entityManager.merge(book);
        transaction.commit();
        entityManager.close();

    }

    @Override
    public Book findBook(Integer bookId) {
        EntityManager entityManager = factory.createEntityManager();
        Book book = entityManager.find(Book.class, bookId);
        return book;
    }

    @Override
    public void remove(Integer bookId) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Book book = entityManager.find(Book.class, bookId);
        entityManager.remove(book);
        transaction.commit();
    }
}