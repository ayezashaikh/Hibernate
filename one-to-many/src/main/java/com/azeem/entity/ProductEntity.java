package com.azeem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_product")
public class ProductEntity {

    @Id
    @Column(name = "product_id")
    private Integer productId;


    @Column(name = "product_name")
    private String productName;

    @Lob
    @Column(name = "product_image")
    private byte[] productImage;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }
}
