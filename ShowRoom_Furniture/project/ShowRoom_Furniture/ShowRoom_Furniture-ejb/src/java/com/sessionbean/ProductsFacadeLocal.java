/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Brands;
import com.entity.Categories;
import com.entity.Products;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nguyen Dinh
 */
@Local
public interface ProductsFacadeLocal {

    void create(Products products);

    void edit(Products products);

    void remove(Products products);

    Products find(Object id);

    List<Products> findAll();

    List<Products> findRange(int[] range);

    int count();

    List<Products> find8NewProduct();

    List<Products> findAll(Integer page, Integer pageSize, Integer categoryId, String title);

    Long countAll(Integer categoryId, String title);

    List<Products> findByTitle(String title, Integer page, Integer pageSize);

    List<Products> findRandom5ByCategoryId(Categories Categories, Integer id);

    List<Products> findProductByBrandId(Brands brands);

    Long countAll(String title);
}
