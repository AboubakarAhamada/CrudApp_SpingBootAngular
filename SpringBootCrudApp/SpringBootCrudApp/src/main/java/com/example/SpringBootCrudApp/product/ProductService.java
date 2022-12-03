package com.example.SpringBootCrudApp.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public  ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    Optional<Product> getOnProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new IllegalStateException("Product with id "+id+ " does not exist!");
        }
        return optionalProduct;
    }
    List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }
    public void deleteProduct(Long id){
        boolean productExists = productRepository.existsById(id);
        if(!productExists){
            throw new IllegalStateException("Product with id "+id+ " does not exist!");
        }
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, Product product){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new IllegalStateException("Product with id "+id+ " does not exist!");
        }
        optionalProduct.get().setName(product.getName());
        optionalProduct.get().setPrice(product.getPrice());
        optionalProduct.get().setQuantity(product.getQuantity());

        productRepository.save(optionalProduct.get());
    }

    List<Product> searchProductByName(String str){
        return productRepository.findByNameContains(str);
    }
}
