/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Brands;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nguyen Dinh
 */
@Stateless
public class BrandsFacade extends AbstractFacade<Brands> implements BrandsFacadeLocal {

    @PersistenceContext(unitName = "ShowRoom_Furniture-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BrandsFacade() {
        super(Brands.class);
    }
    
}
