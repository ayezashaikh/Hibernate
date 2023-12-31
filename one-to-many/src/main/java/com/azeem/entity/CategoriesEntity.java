package com.azeem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_categories")
public class CategoriesEntity {
    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id_fk")
    private List<ProductEntity> lstProducts;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductEntity> getLstProducts() {
        return lstProducts;
    }

    public void setLstProducts(List<ProductEntity> lstProducts) {
        this.lstProducts = lstProducts;
    }
}
