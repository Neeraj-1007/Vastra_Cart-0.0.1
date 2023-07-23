package vastracart.category.service;

import vastracart.category.entity.Category;
import vastracart.category.entity.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryServiceInt {

    public Long loadCategory(Category category);

    public Optional<Category> findByCategoryName(String CategoryName);

    public Category saveCategory(Category category);

    public void updateById(int canceled,Long categoryId);

    public List<Category> getListByCanceled(int canceled);
}
