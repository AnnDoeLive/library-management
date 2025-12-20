package library.dao;
import library.model.Loan;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoanDAO {
    public boolean returnBook(int loanId) {
        String sql = """
        UPDATE loans
        SET returned = true
        WHERE id = ?
    """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, loanId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Loan getLoanById(int id) {
        String sql = "SELECT * FROM loans WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Loan loan = new Loan();
                loan.setId(rs.getInt("id"));
                loan.setBookId(rs.getInt("book_id"));
                loan.setMemberId(rs.getInt("member_id"));

                java.sql.Date loanDate = rs.getDate("loan_date");
                if (loanDate != null)
                    loan.setLoanDate(loanDate.toLocalDate());

                java.sql.Date dueDate = rs.getDate("due_date");
                if (dueDate != null)
                    loan.setDueDate(dueDate.toLocalDate());

                loan.setReturned(rs.getBoolean("returned"));

                return loan;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Loan l) {
        String sql = """
            INSERT INTO loans (book_id, member_id, loan_date, due_date, returned)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, l.getBookId());
            ps.setInt(2, l.getMemberId());
            ps.setDate(3, java.sql.Date.valueOf(l.getLoanDate()));
            ps.setDate(4, java.sql.Date.valueOf(l.getDueDate()));

            ps.setBoolean(5, l.isReturned());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Loan> findAll() {
        List<Loan> list = new ArrayList<>();

        String sql = "SELECT * FROM loans";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Loan loan = new Loan();
                loan.setId(rs.getInt("id"));
                loan.setBookId(rs.getInt("book_id"));
                loan.setMemberId(rs.getInt("member_id"));
                loan.setLoanDate(rs.getDate("loan_date").toLocalDate());
                loan.setDueDate(rs.getDate("due_date").toLocalDate());
                loan.setReturned(rs.getBoolean("returned"));

                list.add(loan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<Loan> findLoansByMemberName(String name) {
        List<Loan> list = new ArrayList<>();
        String sql = """
        SELECT l.*
        FROM loans l
        JOIN members m ON l.member_id = m.id
        WHERE m.name ILIKE ?
    """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Loan loan = new Loan();
                loan.setId(rs.getInt("id"));
                loan.setBookId(rs.getInt("book_id"));
                loan.setMemberId(rs.getInt("member_id"));
                loan.setLoanDate(rs.getDate("loan_date").toLocalDate());
                loan.setDueDate(rs.getDate("due_date").toLocalDate());
                loan.setReturned(rs.getBoolean("returned"));
                list.add(loan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
