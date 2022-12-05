/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service;

import com.entity.Products;
import com.showroomfurniture.dto.ProductDTO;
import java.util.List;

public interface IProductService {

    List<Products> findAll();

    ProductDTO findAllById(Integer id);

    void save(ProductDTO dto);

    ProductDTO edit(ProductDTO dto);

    void delete(Integer id);

    List<Products> find8NewProduct();

    List<Products> findAll(Integer page, Integer pageSize, Integer categoryId, String title);

    Long countAll(Integer categoryId, String title);

    List<Products> findByTitle(String title, Integer page, Integer pageSize);

    List<Products> findRandom5ProductByCategoryId(Integer categoryId, Integer id);

    List<Products> findAllByBrandId(Integer id);

    Long coutAllByTitle(String title);
}
