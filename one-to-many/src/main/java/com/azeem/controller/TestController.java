package com.azeem.controller;

import com.azeem.CategoryDao;
import com.azeem.entity.CategoriesEntity;
import com.azeem.entity.ProductEntity;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    CategoryDao categoryDao;


    @PostMapping("/product")
    void saveCategory(CategoriesEntity categoriesEntity) throws IOException {

        categoriesEntity.setCategoryId(1001);
        categoriesEntity.setCategoryName("HOME");

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("Huwaei");
        productEntity.setProductId(1001);
        productEntity.setProductImage(new FileInputStream("D:\\Hibernate\\image\\mobile.png").readAllBytes());


        ProductEntity productEntity1 = new ProductEntity();
        productEntity1.setProductName("Samsung");
        productEntity1.setProductId(1002);
        productEntity1.setProductImage(new FileInputStream("D:\\Hibernate\\image\\mobile.png").readAllBytes());


        ProductEntity productEntity2 = new ProductEntity();
        productEntity2.setProductName("Samsung");
        productEntity2.setProductId(1003);
        productEntity2.setProductImage(new FileInputStream("D:\\Hibernate\\image\\mobile.png").readAllBytes());


        List<ProductEntity> list = new ArrayList<>();
        list.add(productEntity);
        list.add(productEntity1);
        list.add(productEntity2);
        categoriesEntity.setLstProducts(list);

        categoryDao.saveCategory(categoriesEntity);


    }

    @GetMapping("/product")
    CategoriesEntity fetchCtegory(Integer categoryId) {
        return categoryDao.fetchCtegory(1001);
    }


    @DeleteMapping("/product")
    void removeCategory(Integer categoryId) {

    }

}
