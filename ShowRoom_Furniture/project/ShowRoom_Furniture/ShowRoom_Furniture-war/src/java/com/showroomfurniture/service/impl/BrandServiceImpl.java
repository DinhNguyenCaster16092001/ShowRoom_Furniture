/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service.impl;

import com.entity.Brands;
import com.sessionbean.BrandsFacadeLocal;
import com.showroomfurniture.service.IBrandService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandServiceImpl implements IBrandService {

    BrandsFacadeLocal brandsFacade = lookupBrandsFacadeLocal();

    @Override
    @Transactional
    public List<Brands> findAll() {
        return brandsFacade.findAll();
    }

    private BrandsFacadeLocal lookupBrandsFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (BrandsFacadeLocal) c.lookup("java:global/ShowRoom_Furniture/ShowRoom_Furniture-ejb/BrandsFacade!com.sessionbean.BrandsFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public Brands findById(Integer id) {
        Brands brand = null;
        try {
            brand = brandsFacade.find(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brand;
    }

}
