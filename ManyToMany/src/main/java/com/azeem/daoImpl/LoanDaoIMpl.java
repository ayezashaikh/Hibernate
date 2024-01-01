package com.azeem.daoImpl;

import com.azeem.entity.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;

@Service
public class LoanDaoIMpl implements LoanDao {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

    @Override
    public void saveLaon(Loan loan) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(loan);
        transaction.commit();
    }

    @Override
    public Loan fetLoan(Integer loanId) {
        EntityManager manager = factory.createEntityManager();
        Loan loan = manager.find(Loan.class, loanId);
        return loan;
    }

    @Override
    public void removeLoan(Integer loanId) {
        EntityManager manager = factory.createEntityManager();
        Loan loan = manager.find(Loan.class, loanId);
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.remove(loan);
        transaction.commit();


    }


}
