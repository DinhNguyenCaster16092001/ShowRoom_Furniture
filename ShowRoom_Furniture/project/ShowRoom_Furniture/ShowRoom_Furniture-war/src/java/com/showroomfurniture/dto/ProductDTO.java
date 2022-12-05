/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.dto;

import java.math.BigDecimal;

public class ProductDTO {

    private Integer id;

    private String title;

    private BigDecimal price;

    private int quantity;

    private String shortDescription;

    private String description;

    private Integer status;

    private String image;

    private String substance;

    private Integer brandid;
    
    private String brandName;
    
    private String categoryName;

    private Integer categoryid;

    public ProductDTO() {
    }

    public ProductDTO(String title, BigDecimal price, int quantity, String shortDescription, String description, Integer status, String image, String substance, Integer brandid, Integer categoryid) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.shortDescription = shortDescription;
        this.description = description;
        this.status = status;
        this.image = image;
        this.substance = substance;
        this.brandid = brandid;
        this.categoryid = categoryid;
    }

    public ProductDTO(Integer id, String title, BigDecimal price, int quantity, String shortDescription, String description, Integer status, String image, String substance, Integer brandid, Integer categoryid) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.shortDescription = shortDescription;
        this.description = description;
        this.status = status;
        this.image = image;
        this.substance = substance;
        this.brandid = brandid;
        this.categoryid = categoryid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }
    
    

    @Override
    public String toString() {
        return "ProductDTO{" + "id=" + id + ", title=" + title + ", price=" + price + ", quantity=" + quantity + ", shortDescription=" + shortDescription + ", description=" + description + ", status=" + status + ", image=" + image + ", substance=" + substance + ", brandid=" + brandid + ", categoryid=" + categoryid + '}';
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
