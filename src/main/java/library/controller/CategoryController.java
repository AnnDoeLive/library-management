package library.controller;

import library.model.Category;
import library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * GET /api/categories
     * Lấy danh sách tất cả danh mục
     */
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        // TODO: Implement logic to get all categories
        // TODO: Handle exceptions and return appropriate HTTP status
        return ResponseEntity.ok(null);
    }

    /**
     * GET /api/categories/{id}
     * Lấy thông tin danh mục theo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        // TODO: Validate id parameter
        // TODO: Implement logic to get category by id
        // TODO: Return 404 if category not found
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }

    /**
     * GET /api/categories/{id}/books
     * Lấy danh sách sách trong một danh mục
     */
    @GetMapping("/{id}/books")
    public ResponseEntity<?> getBooksByCategory(@PathVariable int id) {
        // TODO: Validate id parameter
        // TODO: Check if category exists
        // TODO: Implement logic to get books by category id
        // TODO: Return 404 if category not found
        // TODO: Handle exceptions
        return ResponseEntity.ok(null);
    }
}

