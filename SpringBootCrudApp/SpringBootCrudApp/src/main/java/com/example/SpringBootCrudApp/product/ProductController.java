package com.example.SpringBootCrudApp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("api/v1")

public class ProductController {

    public final ProductService productService;

    public  ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/products/{id}")
    public Optional<Product> getOnProduct(@PathVariable("id")Long id){
        return productService.getOnProduct(id);
    }
    @GetMapping(value = "/products")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
    @PostMapping(value = "/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PutMapping(value = "/products/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        productService.updateProduct(id, product);
    }

    @DeleteMapping(path= "/products/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

}
