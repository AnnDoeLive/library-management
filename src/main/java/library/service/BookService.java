package library.service;

import library.model.Book;
import java.util.List;

public interface BookService {
    // TODO: Implement all methods
    
    List<Book> getAllBooks();
    Book getBookById(int id);
    Book createBook(Book book);
    Book updateBook(int id, Book book);
    boolean deleteBook(int id);
    List<Book> searchBooksByTitle(String title);
    List<Book> getBooksByCategory(String category);
    List<Book> getBooksByAuthor(String author);
    Book updateBookQuantity(int id, int quantity);
    Integer getQuantityById(int id);
}

