package library.repository;

import library.model.Loan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoanRowMapper implements RowMapper<Loan> {

    @Override
    public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
        Loan loan = new Loan();
        loan.setId(rs.getInt("id"));
        loan.setBookId(rs.getInt("book_id"));
        loan.setMemberId(rs.getInt("member_id"));

        java.sql.Date loanDate = rs.getDate("loan_date");
        if (loanDate != null) loan.setLoanDate(loanDate.toLocalDate());
        else loan.setLoanDate(null);

        java.sql.Date dueDate = rs.getDate("due_date");
        if (dueDate != null) loan.setDueDate(dueDate.toLocalDate());
        else loan.setDueDate(null);

        // assumed column 'returned' is boolean or tinyint(1)
        loan.setReturned(rs.getBoolean("returned"));

        return loan;
    }
}
