package com.example.SpringBootCrudApp.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //TODO : Why I cannot get more than one result ? (jakarta.persistence.NonUniqueResultException)
    @Query("Select p from Product p where p.name like %:str%")

    List<Product> findByNameContains(String str);

}
