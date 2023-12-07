package com.azeem.dao.impl;

import com.azeem.entity.ProductEntity;

public interface ProductDao {


    public ProductEntity saveProduct(ProductEntity productEntity);

    public ProductEntity loadProduct(Integer productId);

    public ProductEntity updateProduct(Integer productId, Double price);

    public void deleteProduct(Integer productId);


}
