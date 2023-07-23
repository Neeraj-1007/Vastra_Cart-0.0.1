package vastracart.category.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vastracart.category.entity.Category;
import vastracart.category.entity.SubCategory;
import vastracart.category.repository.CategoryRepository;
import vastracart.category.repository.SubCategoryRepository;
import vastracart.category.service.SubCategoryServiceInt;


@Service
public class SubCategoryServiceImpl implements SubCategoryServiceInt {

    @Autowired
    private SubCategoryRepository  subCategoryRepository;


    @Override
    public Long loadSubCategory(SubCategory subCategory) {
      SubCategory subCategory1=  subCategoryRepository.save(subCategory);
        return subCategory1.getSubCategoryId();
    }


}
