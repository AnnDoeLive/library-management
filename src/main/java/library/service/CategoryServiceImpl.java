package library.service;

import library.dao.CategoryDAO;
import library.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> getAllCategories() {
        // TODO: Implement logic to get all categories
        return null;
    }

    @Override
    public Category getCategoryById(int id) {
        // TODO: Implement logic to get category by id
        return null;
    }

    @Override
    public List<?> getBooksByCategory(int categoryId) {
        // TODO: Implement logic to get books by category
        return null;
    }
}

