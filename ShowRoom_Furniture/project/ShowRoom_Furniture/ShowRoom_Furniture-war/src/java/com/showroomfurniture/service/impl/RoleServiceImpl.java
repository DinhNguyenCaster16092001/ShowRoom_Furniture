/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service.impl;

import com.entity.Roles;
import com.sessionbean.RolesFacadeLocal;
import com.showroomfurniture.service.IRoleService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    RolesFacadeLocal rolesFacade = lookupRolesFacadeLocal();

    @Override
    public List<Roles> findAll() {
        return rolesFacade.findAll();
    }

    private RolesFacadeLocal lookupRolesFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (RolesFacadeLocal) c.lookup("java:global/ShowRoom_Furniture/ShowRoom_Furniture-ejb/RolesFacade!com.sessionbean.RolesFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public Roles findById(Integer id) {
        return rolesFacade.find(id);
    }

}
