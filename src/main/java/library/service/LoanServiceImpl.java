package library.service;

import library.dao.LoanDAO;
import library.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanDAO loanDAO;

    @Override
    public List<Loan> getLoansByMemberName(String name) {
        return loanDAO.findLoansByMemberName(name);
    }

    @Override
    public Loan createLoan(Loan loan) {
        boolean success = loanDAO.insert(loan);
        return success ? loan : null;
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanDAO.findAll();
    }

    @Override
    public Loan getLoanById(int id) {
        return null;
    }

    public boolean deleteLoan(int id) {

        return LoanDAO.delete(id) > 0;
    }

    @Override
    public List<Loan> getActiveLoans() {
        return List.of();
    }

    @Override
    public List<Loan> getOverdueLoans() {
        return List.of();
    }

    @Override
    public List<Loan> getLoansByBookId(int bookId) {
        return List.of();
    }

    @Override
    public List<Loan> getLoansByMemberId(int memberId) {
        return List.of();
    }

    @Override
    public Loan extendLoan(int loanId, int days) {
        return null;
    }

    @Override
    public Loan returnBook(int loanId) {
        boolean success = loanDAO.returnBook(loanId);
        if (!success) return null;

        return loanDAO.getLoanById(loanId);
    }
    
}