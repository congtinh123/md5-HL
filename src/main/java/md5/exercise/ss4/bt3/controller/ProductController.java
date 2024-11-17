package md5.exercise.ss4.bt3.controller;

import md5.exercise.ss4.bt3.entity.Product;
import md5.exercise.ss4.bt3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> product1s = productService.findAll();
        return ResponseEntity.ok(product1s);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product1){
        Product newProduct = productService.save(product1);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product1){
        product1.setProductId(id);
        Product updatedProduct = productService.save(product1);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        Product product1 = productService.findById(id);
        return ResponseEntity.ok(product1);
    }
}
