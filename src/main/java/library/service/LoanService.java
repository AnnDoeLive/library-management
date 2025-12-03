package library.service;

import library.model.Loan;
import java.util.List;

public interface LoanService {
    // TODO: Implement all methods
    
    Loan createLoan(Loan loan);
    List<Loan> getAllLoans();
    Loan getLoanById(int id);
    Loan returnBook(int loanId);
    List<Loan> getActiveLoans();
    List<Loan> getOverdueLoans();
    List<Loan> getLoansByBookId(int bookId);
    List<Loan> getLoansByMemberId(int memberId);
    Loan extendLoan(int loanId, int days);
    double calculateFine(int loanId);
}

