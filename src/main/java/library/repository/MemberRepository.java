package library.repository;

import library.model.Loan;
import library.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public MemberRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Lấy tất cả thành viên
    public List<Member> findAll() {
        String sql = "SELECT id, name, email, phone FROM members";
        return jdbc.query(sql, new MemberRowMapper());
    }

    // Lấy theo ID
    public Member findById(int id) {
        String sql = "SELECT id, name, email, phone FROM members WHERE id = ?";
        List<Member> list = jdbc.query(sql, new MemberRowMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    // Lấy theo email
    public Member findByEmail(String email) {
        String sql = "SELECT id, name, email, phone FROM members WHERE email = ?";
        List<Member> list = jdbc.query(sql, new MemberRowMapper(), email);
        return list.isEmpty() ? null : list.get(0);
    }

    // Tạo mới
    public int save(Member m) {
        String sql = "INSERT INTO members(name, email, phone) VALUES (?, ?, ?)";
        return jdbc.update(sql,
                m.getName(),
                m.getEmail(),
                m.getPhone()
        );
    }

    // Update
    public int update(int id, Member m) {
        String sql = "UPDATE members SET name = ?, email = ?, phone = ? WHERE id = ?";
        return jdbc.update(sql,
                m.getName(),
                m.getEmail(),
                m.getPhone(),
                id
        );
    }

    // Delete
    public int delete(int id) {
        String sql = "DELETE FROM members WHERE id = ?";
        return jdbc.update(sql, id);
    }

    // Kiểm tra còn phiếu mượn đang active không
    public boolean hasActiveLoans(int memberId) {
        String sql = "SELECT COUNT(*) FROM loans WHERE member_id = ? AND returned = false";
        Integer count = jdbc.queryForObject(sql, Integer.class, memberId);
        return count != null && count > 0;
    }

    // Lấy danh sách loans của member
    public List<Loan> findLoans(int memberId) {
        String sql = "SELECT id, book_id, member_id, loan_date, due_date, returned FROM loans WHERE member_id = ?";
        return jdbc.query(sql, new LoanRowMapper(), memberId);
    }
}
