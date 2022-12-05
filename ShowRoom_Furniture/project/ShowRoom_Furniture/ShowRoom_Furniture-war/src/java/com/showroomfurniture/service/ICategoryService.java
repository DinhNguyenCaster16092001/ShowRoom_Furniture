/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service;

import com.entity.Categories;
import java.util.List;

public interface ICategoryService {

    List<Categories> findAll();

    Categories findById(Integer id);

    void save(Categories categories);
    
    Categories edit(Categories categories);
    
    void delete(Integer id);
}
