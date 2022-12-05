/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.dto;

import java.math.BigDecimal;

/**
 *
 * @author Nguyen Dinh
 */
public class OrderDetailsDTO {

    private String title;

    private String image;

    private int quantity;

    private BigDecimal price;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String title, String image, int quantity, BigDecimal price) {
        this.title = title;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }
    
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" + "title=" + title + ", image=" + image + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
    
    
}
