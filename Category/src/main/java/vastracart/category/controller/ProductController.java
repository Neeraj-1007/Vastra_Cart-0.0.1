package vastracart.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vastracart.category.entity.Category;
import vastracart.category.entity.Product;
import vastracart.category.service.ProductServiceInt;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceInt productServiceInt;

    @GetMapping("/getProduct/name/{name}")
    private ResponseEntity<Product> loadProductByName(@PathVariable String name){
        Product product=new Product();
        Optional<Product> product1 =  productServiceInt.getByName(name);
        if(!product1.isPresent()){
            product.setResposneStatus("FAILED");
            product.setResponseMessage("NO DATA FOUND !!");
            return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
        }
        product=product1.get();
        product.setResposneStatus("SUCCESS");
        product.setResponseMessage("GET THE RESULT ");

        return new ResponseEntity<Product>(product, HttpStatus.FOUND);
    }

    @GetMapping("/getProduct/id/{id}")
    private ResponseEntity<Product> loadProductById(@PathVariable Long id){
        Product product=new Product();
      Optional<Product> product1 =productServiceInt.getById(id);
        if(!product1.isPresent()){
            product.setResposneStatus("FAILED");
            product.setResponseMessage("NO DATA FOUND !!");
            return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
        }
      product=product1.get();
      product.setResposneStatus("SUCCESS");
      product.setResponseMessage("GET THE RESULT ");
        return new ResponseEntity<Product>(product, HttpStatus.FOUND);
    }

    @GetMapping("/getProduct")
    private ResponseEntity<List<Product>> loadProductAll(){
      List<Product> list= productServiceInt.getList();
      if(list.size()==0){
          return new ResponseEntity<List<Product>>((List<Product>) null, HttpStatus.NOT_FOUND);
      }
        return new ResponseEntity<List<Product>>( list, HttpStatus.FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product product1=productServiceInt.saveProduct(product);
        if(product1==null){
            product1.setResposneStatus("FAILED");
            product1.setResponseMessage("COULD NOT SAVE DATA !!");
            return new ResponseEntity<Product>(product1,HttpStatus.SERVICE_UNAVAILABLE);
        }else{
            product1.setResposneStatus("SUCCESS");
            product1.setResponseMessage("SAVE DATA SUCCESSFULLY !!");
            return new ResponseEntity<Product>(product1,HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @PostMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        try {
            productServiceInt.updateProduct(product.getName(), product.getId());
            product.setResposneStatus("SUCCESS");
            product.setResponseMessage("SAVE DATA SUCCESSFULLY !!");
            return new ResponseEntity<Product>(product,HttpStatus.SERVICE_UNAVAILABLE);
        }catch (Exception e) {
            product.setResposneStatus("FAILED");
            product.setResponseMessage(e.getMessage());
            return new ResponseEntity<Product>(product, HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

}
