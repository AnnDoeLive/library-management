package library.service;

import library.dao.BookDAO;
import library.model.Book;
import library.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<Category> getAllCategories() {
        // Lấy danh sách category dạng String từ DAO
        List<String> names = bookDAO.findAllDistinctCategories();

        // Convert sang List<Category>
        List<Category> categories = new ArrayList<>();
        for (String name : names) {
            categories.add(new Category(name));
        }

        return categories;
    }

    @Override
    public List<Book> findByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDAO.getById(id);
    }

    @Override
    public Book createBook(Book book) {
        boolean success = bookDAO.insert(book);
        return success ? book : null;
    }

    @Override
    public Book updateBook(int id, Book book) {
        book.setId(id);
        boolean success = bookDAO.update(book);
        return success ? book : null;
    }

    @Override
    public boolean deleteBook(int id) {
        return bookDAO.delete(id);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return bookDAO.searchBooksByTitle(title);
    }

    @Override
    public List<Book> getBooksByCategory(String category) {
        return bookDAO.findByCategory(category);
    }


    @Override
    public Book updateBookQuantity(int id, int quantity) {
        return bookDAO.updateQuantity(id, quantity);
    }

//    @Override
//    public Integer getQuantityById(int id) {
//        return bookDAO.getQuantityById(id);
//    }
}
