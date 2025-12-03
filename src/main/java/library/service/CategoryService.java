package library.service;

import library.model.Category;
import java.util.List;

public interface CategoryService {
    // TODO: Implement all methods
    
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    List<?> getBooksByCategory(int categoryId);
}

