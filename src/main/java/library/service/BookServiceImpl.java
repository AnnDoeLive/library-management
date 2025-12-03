//package library.service;
//
//import library.dao.BookDAO;
//import library.model.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookServiceImpl implements BookService {
//
//    @Autowired
//    private BookDAO bookDAO;
//
//    @Override
//    public List<Book> getAllBooks() {
//        // TODO: Implement logic to get all books
//        return null;
//    }
//
//    @Override
//    public Book getBookById(int id) {
//        // TODO: Implement logic to get book by id
//        return null;
//    }
//
//    @Override
//    public Book createBook(Book book) {
//        // TODO: Validate book data
//        // TODO: Implement logic to create book
//        return null;
//    }
//
//    @Override
//    public Book updateBook(int id, Book book) {
//        // TODO: Validate book data
//        // TODO: Check if book exists
//        // TODO: Implement logic to update book
//        return null;
//    }
//
//    @Override
//    public boolean deleteBook(int id) {
//        // TODO: Check if book has active loans
//        // TODO: Implement logic to delete book
//        return false;
//    }
//
//    @Override
//    public List<Book> searchBooksByTitle(String title) {
//        // TODO: Implement logic to search books by title
//        return null;
//    }
//
//    @Override
//    public List<Book> getBooksByCategory(String category) {
//        // TODO: Implement logic to get books by category
//        return null;
//    }
//
//    @Override
//    public List<Book> getBooksByAuthor(String author) {
//        // TODO: Implement logic to get books by author
//        return null;
//    }
//
//    @Override
//    public Book updateBookQuantity(int id, int quantity) {
//        // TODO: Validate quantity
//        // TODO: Implement logic to update book quantity
//        return null;
//    }
//}
//
package library.service;

import library.dao.BookDAO;
import library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        // Gọi DAO để lấy tất cả sách
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
    public List<Book> getBooksByCategory(String category) {
        // TODO: Implement logic
        return null;
    }
    @Override
    public Book updateBookQuantity(int id, int quantity) {
        return bookDAO.updateQuantity(id, quantity);
    }
    @Override
    public List<Book> searchBooksByTitle(String title) {
        return bookDAO.searchBooksByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        // TODO: Implement logic
        return null;
    }



    @Override
    public Integer getQuantityById(int id) {
        return 0;
    }
}
