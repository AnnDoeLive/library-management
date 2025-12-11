//package library.service;
//
//import library.dao.CategoryDAO;
//import library.model.Category;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CategoryServiceImpl implements CategoryService {
//
//    @Autowired
//    private CategoryDAO categoryDAO;
//
//    @Override
//    public List<String> findAllDistinctCategories() {
//        return List.of();
//    }
//
//    @Override
//    public List<Category> getAllCategories() {
//        // TODO: Implement logic to get all categories
//        return null;
//    }
//
//    @Override
//    public Category getCategoryById(int id) {
//        // TODO: Implement logic to get category by id
//        return null;
//    }
//
//    @Override
//    public List<?> getBooksByCategory(int categoryId) {
//        // TODO: Implement logic to get books by category
//        return null;
//    }
//}
//
package library.service;

import library.dao.BookDAO;
import library.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<String> findAllDistinctCategories() {
        return List.of();
    }

    @Override
    public List<Category> getAllCategories() {
        // Lấy toàn bộ tên category (String)
        List<String> category = bookDAO.findAllDistinctCategories();

        // Convert sang object Category
        List<Category> result = new ArrayList<>();
        for (String name : category) {
            result.add(new Category(name));
        }

        return result; // <<< QUAN TRỌNG: TRẢ VỀ LIST, KHÔNG TRẢ VỀ SỐ
    }

    @Override
    public Category getCategoryById(int id) {
        return null;
    }

    @Override
    public List<?> getBooksByCategory(int categoryId) {
        return List.of();
    }
}
