package library.service;

import library.model.Loan;
import java.util.List;

public interface LoanService {

    Loan returnBook(int loanId);

    List<Loan> getLoansByMemberName(String name);
    Loan createLoan(Loan loan);
    List<Loan> getAllLoans();
    Loan getLoanById(int id);
    boolean deleteLoan(int id);
    List<Loan> getActiveLoans();
    List<Loan> getOverdueLoans();
    List<Loan> getLoansByBookId(int bookId);
    List<Loan> getLoansByMemberId(int memberId);
    Loan extendLoan(int loanId, int days);
}