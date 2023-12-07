package com.azeem.controller;

import com.azeem.dao.impl.ProdDaoImpl;
import com.azeem.dao.impl.ProductDao;
import com.azeem.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductDao productDao;

    @PostMapping("/product")
    public ProductEntity saveProduct(@RequestBody  ProductEntity productEntity) {


        return productDao.saveProduct(productEntity);
    }

    @GetMapping("/product/{id}")
    public ProductEntity loadProduct(@PathVariable int id) {
        return productDao.loadProduct(id);
    }

    @PutMapping("/product/{id}/{price}")
    public ProductEntity updateProduct(@PathVariable("id") int id, @PathVariable("price") double price) {
        return productDao.updateProduct(id, price);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productDao.deleteProduct(id);
    }


}
