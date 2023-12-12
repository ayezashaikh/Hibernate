package com.azeem.key;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_product")
public class ProductEntity implements Serializable {

    @Id
    @Column(name = "product_id")
    private Integer productId;


    @Column(name = "product_name")
    private String productName;


    @Column(name="quantity")
    private Integer quantity;


    @Column(name = "unit_price")
    private Double unitPrice;


    @CreationTimestamp
    @Column(name = "created_on")
    private LocalDateTime createdOn;


    @UpdateTimestamp
    @Column(name = "lastupdated_on")
    private LocalDateTime updated_on;

    public LocalDateTime getCreatedOn() {



        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }


    @Override
    public String toString() {
        return "ProductEntity{" +
                "product_id=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", createdOn=" + createdOn +
                ", updated_on=" + updated_on +
                '}';
    }


    public ProductEntity() {
    }

    public Integer getProduct_id() {
        return productId;
    }

    public void setProduct_id(Integer product_id) {
        this.productId = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDateTime getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(LocalDateTime updated_on) {
        this.updated_on = updated_on;
    }
}
