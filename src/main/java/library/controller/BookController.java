package library.controller;

import library.model.Book;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;
    /** GET /api/books/search?title={title} - Tìm kiếm sách theo title */
//    @GetMapping("/search/book/{title}")
//    public ResponseEntity<List<Book>> search(@PathVariable String title) {
//        System.out.println("Client search = " + title);
//        List<Book> result = bookService.searchBooksByTitle(title);
//        return ResponseEntity.ok(result);
//    }



    @GetMapping("/{id}/quantity")
    public ResponseEntity<?> getQuantity(@PathVariable int id) {

        Integer quantity = bookService.getQuantityById(id);

        if (quantity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book not found");
        }

        return ResponseEntity.ok(
                Map.of(
                        "id", id,
                        "quantity", quantity
                )
        );
    }

    /** GET /api/books - Lấy danh sách tất cả sách */
    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }


    /** GET /api/books/{id} - Lấy sách theo ID */
    @GetMapping("/id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /** POST /api/books - Thêm sách mới */
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book created = bookService.createBook(book);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /** PUT /api/books/{id} - Cập nhật sách */
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updated = bookService.updateBook(id, book);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /** DELETE /api/books/{id} - Xóa sách */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
        System.out.println("Searching for: " + title);
        List<Book> result = bookService.searchBooksByTitle(title);
        return ResponseEntity.ok(result);
    }





    /** GET /api/books/category/{category} - Lấy sách theo category */
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String category) {
        List<Book> books = bookService.getBooksByCategory(category);
        return ResponseEntity.ok(books);
    }

    /** GET /api/books/author/{author} - Lấy sách theo author */
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        List<Book> books = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    /** PATCH /api/books/{id}/quantity - Cập nhật số lượng sách */
    @PatchMapping("/{id}/quantity")
    public ResponseEntity<?> updateQuantity(
            @PathVariable int id,
            @RequestParam int quantity
    ) {
        Book updated = bookService.updateBookQuantity(id, quantity);

        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book not found or update failed");
        }

        return ResponseEntity.ok(updated);
    }


}
