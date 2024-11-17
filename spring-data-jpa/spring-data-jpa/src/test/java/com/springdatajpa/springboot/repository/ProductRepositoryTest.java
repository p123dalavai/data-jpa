package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepo;

    @Test
    void saveMethod(){
        Product product=new Product();
        product.setName("p1");
        product.setDescription("product one");
        product.setActive(true);
        product.setSku("100ABC");
        product.setImageUrl("product.img");
        Product savedObject=productRepo.save(product);
        System.out.print(savedObject.toString());

    }

    @Test
    void updateUsingSaveMethod(){
        //find or retrive an entity by id
        Long id=1l;
        Product product=productRepo.findById(id).get();

        //update the entity
        product.setName("product1new");

        //save the entity
        productRepo.save(product);
    }

    @Test
    void deleteMethod(){
        //find an entity by id
        Long id=1l;
        Product product=productRepo.findById(id).get();

        //delete entity
        productRepo.delete(product);
    }

    @Test
    void deleteAllMethod(){
        //deletes all records
        productRepo.deleteAll();
    }

    @Test
    void deleteAll2method(){
        Product product=productRepo.findById(1L).get();
        productRepo.deleteAll(List.of(product));
    }

    @Test
    void countMethod(){
        long count=productRepo.count();
        System.out.print(count);
    }


    @Test
    void existsByIdMethod(){
        Long id=1l;
        boolean result=productRepo.existsById(id);
        System.out.print(result);


    }

}