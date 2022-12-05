/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.dto;

public class CartDTO {

    private ProductDTO productDTO;
    private int quantity;

    public CartDTO() {
    }

    public CartDTO(ProductDTO productDTO, int quantity) {
        this.productDTO = productDTO;
        this.quantity = quantity;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartDTO{" + "productDTO=" + productDTO + ", quantity=" + quantity + '}';
    }

}
