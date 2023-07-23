package vastracart.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vastracart.category.entity.Category;
import vastracart.category.entity.CategoryResposne;
import vastracart.category.service.CategoryServiceInt;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceInt categoryServiceInt;


    @GetMapping("/getCategory/{name}")
    public ResponseEntity<CategoryResposne> loadCategoryByName(@PathVariable String  name){
        CategoryResposne categoryResposne=new CategoryResposne();

        Optional<Category> category = categoryServiceInt.findByCategoryName(name);
        if(category.isPresent()) {
            categoryResposne.setResposneBody(category.get());
            categoryResposne.setResposneStatus("SUCCESS");
            categoryResposne.setResponseMessage("Fetch Data Successfully !!");
            return new ResponseEntity<CategoryResposne>(categoryResposne, HttpStatus.FOUND);
        }else{
            categoryResposne.setResposneStatus("FAILED");
            categoryResposne.setResponseMessage("no data found");
            return new ResponseEntity<CategoryResposne>(categoryResposne,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryResposne> saveProduct(@RequestBody Category category){
        CategoryResposne categoryResposne=new CategoryResposne();
        Category category1=categoryServiceInt.saveCategory(category);
        if(category1==null){
            categoryResposne.setResposneBody(category1);
            categoryResposne.setResposneStatus("FAILED");
            categoryResposne.setResponseMessage("COULD NOT SAVE DATA !!");
            return new ResponseEntity<CategoryResposne>(categoryResposne,HttpStatus.FOUND);
        }else{
            categoryResposne.setResposneStatus("SUCCESS");
            categoryResposne.setResponseMessage("SAVE DATA SUCCESSFULLY !!");
            return new ResponseEntity<CategoryResposne>(categoryResposne,HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @PostMapping("updateCanceledById")
    public ResponseEntity<CategoryResposne> updateCancel(@RequestBody Category category){
        CategoryResposne categoryResposne=new CategoryResposne();

        categoryServiceInt.updateById(category.getCanceled(), category.getCategoryId());
        categoryResposne.setResposneBody(category);
        categoryResposne.setResposneStatus("SUCCESS");
        categoryResposne.setResponseMessage("UPDATED SUCCESSFULLY !!");
        return new ResponseEntity<CategoryResposne>(categoryResposne,HttpStatus.FOUND);
    }
    @GetMapping("/getCategory/canceled/{canceled}")
    public ResponseEntity<List<Category>> loadAllCanceled(@PathVariable int  canceled){
        List<Category> category = categoryServiceInt.getListByCanceled(canceled);
            return new ResponseEntity<List<Category>>(category, HttpStatus.FOUND);

    }

}
