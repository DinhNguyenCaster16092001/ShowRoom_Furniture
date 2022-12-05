/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service.impl;

import com.entity.Orders;
import com.entity.Users;
import com.sessionbean.OrdersFacadeLocal;
import com.sessionbean.UsersFacadeLocal;
import com.showroomfurniture.service.IOrderService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    
    UsersFacadeLocal usersFacade = lookupUsersFacadeLocal();
    
    OrdersFacadeLocal ordersFacade = lookupOrdersFacadeLocal();
    
    @Override
    public void save(Orders orders) {
        ordersFacade.create(orders);
    }
    
    @Override
    public Orders findLastOrderByUserId(Integer userId) {
        Users users = usersFacade.find(userId);
        return ordersFacade.findLastOrderByUserId(users);
    }
    
    private OrdersFacadeLocal lookupOrdersFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (OrdersFacadeLocal) c.lookup("java:global/ShowRoom_Furniture/ShowRoom_Furniture-ejb/OrdersFacade!com.sessionbean.OrdersFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    private UsersFacadeLocal lookupUsersFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (UsersFacadeLocal) c.lookup("java:global/ShowRoom_Furniture/ShowRoom_Furniture-ejb/UsersFacade!com.sessionbean.UsersFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    @Override
    public List<Orders> findAllByUserId(Integer userId) {
        Users users = usersFacade.find(userId);
        return ordersFacade.findAllByUserId(users);
    }
    
    @Override
    public List<Orders> findAll() {
        return ordersFacade.findAll();
    }
    
    @Override
    public void update(Integer id) {
        Orders orders = ordersFacade.find(id);
        orders.setStatus(2);
        ordersFacade.edit(orders);
    }
    
}
