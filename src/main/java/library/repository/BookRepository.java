package library.repository;

import library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public BookRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Lấy tất cả books
    public List<Book> findAll() {
        String sql = "SELECT id, title, author, publisher, category, quantity FROM books";
        return jdbc.query(sql, new BookRowMapper());
    }

    // Lấy books theo category (exact match)
    public List<Book> findByCategory(String category) {
        String sql = "SELECT id, title, author, publisher, category, quantity FROM books WHERE category = ?";
        return jdbc.query(sql, new Object[]{category}, new BookRowMapper());
    }

    // Lấy danh sách category distinct (nếu cần)
    public List<String> findAllDistinctCategories() {
        String sql = "SELECT DISTINCT category FROM books WHERE category IS NOT NULL";
        return jdbc.queryForList(sql, String.class);
    }
}
