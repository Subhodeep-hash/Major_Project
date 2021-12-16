package com.example.Product_Management.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_product")
public class MasterProduct {
    @Id
    @Column(name = "Product_ID", nullable = false)
    private Integer id;

    @Column(name = "Product_Price")
    private Integer productPrice;

    @Column(name = "Product_Name", length = 45)
    private String productName;

    @Column(name = "Product_Description", length = 45)
    private String productDescription;

    @Column(name = "Product_Count")
    private Integer productCount;

    public MasterProduct(Integer id, Integer productPrice, String productName, String productDescription, Integer productCount) {
        this.id = id;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCount = productCount;
    }

    public MasterProduct() {
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}