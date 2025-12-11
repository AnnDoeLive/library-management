package library.service;

import library.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryService {
    // TODO: Implement all methods

//    @Query("SELECT DISTINCT b.category FROM Book b")
    List<String> findAllDistinctCategories();

    List<Category> getAllCategories();
    Category getCategoryById(int id);
    List<?> getBooksByCategory(int categoryId);
}


