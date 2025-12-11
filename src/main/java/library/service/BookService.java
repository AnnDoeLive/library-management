package library.service;

import library.model.Book;
import java.util.List;

public interface BookService {
    // TODO: Implement all methods
    List<Book> findByCategory(String category);



    List<Book> getAllBooks();
    Book getBookById(int id);
    Book createBook(Book book);
    Book updateBook(int id, Book book);
    boolean deleteBook(int id);
    List<Book> searchBooksByTitle(String title);
    List<Book> getBooksByCategory(String category);
    Book updateBookQuantity(int id, int quantity);
}

