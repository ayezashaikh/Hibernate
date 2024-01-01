package com.azeem.daoImpl;

import com.azeem.entity.Loan;

public interface LoanDao {

    void saveLaon(Loan loan);

    Loan fetLoan(Integer loanId);


    void removeLoan(Integer loanId);
}
