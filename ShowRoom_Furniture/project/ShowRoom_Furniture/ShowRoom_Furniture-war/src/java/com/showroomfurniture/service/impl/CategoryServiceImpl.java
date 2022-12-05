/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service.impl;

import com.entity.Categories;
import com.sessionbean.CategoriesFacadeLocal;
import com.showroomfurniture.service.ICategoryService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    CategoriesFacadeLocal categoriesFacade = lookupCategoriesFacadeLocal();

    @Override
    @Transactional
    public List<Categories> findAll() {
        return categoriesFacade.findAll();
    }

    @Override
    public Categories findById(Integer id) {
        Categories categories = null;
        try {
            categories = categoriesFacade.find(id);
        } catch (NullPointerException e) {
            e.getMessage();
        }
        return categories;
    }

    @Override
    @Transactional
    public void save(Categories categories) {
        categoriesFacade.create(categories);
    }

    @Override
    public Categories edit(Categories categories) {
        Categories categoriesInDB = null;
        if (categories.getId() != null) {
            categoriesFacade.edit(categories);
            categoriesInDB = categoriesFacade.find(categories.getId());
        }
        return categoriesInDB;
    }

    @Override
    public void delete(Integer id) {
        Categories categories = categoriesFacade.find(id);
        categoriesFacade.remove(categories);
    }

    private CategoriesFacadeLocal lookupCategoriesFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CategoriesFacadeLocal) c.lookup("java:global/ShowRoom_Furniture/ShowRoom_Furniture-ejb/CategoriesFacade!com.sessionbean.CategoriesFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
