/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Categories;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nguyen Dinh
 */
@Stateless
public class CategoriesFacade extends AbstractFacade<Categories> implements CategoriesFacadeLocal {

    @PersistenceContext(unitName = "ShowRoom_Furniture-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriesFacade() {
        super(Categories.class);
    }
    
}
