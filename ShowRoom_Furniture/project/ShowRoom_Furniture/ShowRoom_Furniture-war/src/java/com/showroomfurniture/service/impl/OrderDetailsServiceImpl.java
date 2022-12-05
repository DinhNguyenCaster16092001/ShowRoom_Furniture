/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service.impl;

import com.entity.OrderDetails;
import com.sessionbean.OrderDetailsFacadeLocal;
import com.showroomfurniture.service.IOrderDetailService;
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
public class OrderDetailsServiceImpl implements IOrderDetailService {

    OrderDetailsFacadeLocal orderDetailsFacade = lookupOrderDetailsFacadeLocal();

    @Override
    public void save(OrderDetails orderDetails) {
        orderDetailsFacade.create(orderDetails);
    }

    private OrderDetailsFacadeLocal lookupOrderDetailsFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (OrderDetailsFacadeLocal) c.lookup("java:global/ShowRoom_Furniture/ShowRoom_Furniture-ejb/OrderDetailsFacade!com.sessionbean.OrderDetailsFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public List<OrderDetails> findAllByOrderId(Integer orderId) {
        return orderDetailsFacade.findAllByOrderId(orderId);
    }

  
}
