package vastracart.category.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vastracart.category.entity.Category;
import vastracart.category.entity.Product;
import vastracart.category.entity.SubCategory;
import vastracart.category.repository.CategoryRepository;
import vastracart.category.repository.SubCategoryRepository;
import vastracart.category.service.CategoryServiceInt;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryServiceInt {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;


    @Override
    public Long loadCategory(Category category) {
        Category category1 = categoryRepository.save(category);
        return category1.getCategoryId();
    }

    @Override
    public Optional<Category> findByCategoryName(String categoryName) {
        Optional<Category> category = categoryRepository.findByCategoryName(categoryName);
        return category;
    }

    @Override
    public Category saveCategory(Category category) {
        Category category1 = categoryRepository.save(category);
        return category1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateById(int canceled,Long categoryId) {
        categoryRepository.updateCategoryById(canceled,categoryId);
    }

    @Override
    public List<Category> getListByCanceled(int canceled) {
        List<Category> categoryList=categoryRepository.getCategoryByCanceled(canceled);
        return categoryList;
    }
}
