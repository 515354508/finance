package com.zsc.finance.service;

import com.zsc.finance.entity.Loan;

import java.util.List;

public interface LoanService {

    Integer insertLoan(Loan loan);

    List<Loan> selectLoanByLoanId(Integer loanId);

    List<Loan> selectAllLoanByApplyStatusAsc();

    List<Loan> selectAllExamedLoan();

    Loan selectLoanById(Integer id);

    Integer updateLoan(Loan loan);
    public Integer deleteLoanByUserId(Integer id);
}
