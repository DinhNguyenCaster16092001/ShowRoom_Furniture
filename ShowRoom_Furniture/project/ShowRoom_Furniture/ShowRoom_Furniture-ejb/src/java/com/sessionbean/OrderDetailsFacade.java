/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.OrderDetails;
import com.entity.Orders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nguyen Dinh
 */
@Stateless
public class OrderDetailsFacade extends AbstractFacade<OrderDetails> implements OrderDetailsFacadeLocal {

    @PersistenceContext(unitName = "ShowRoom_Furniture-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderDetailsFacade() {
        super(OrderDetails.class);
    }

    @Override
    public List<OrderDetails> findAllByOrderId(Integer orderId) {
        try {
            Query query = em.createQuery("SELECT od FROM OrderDetails od WHERE od.orderDetailsPK.orderid=:orderId");
            query.setParameter("orderId", orderId);
            return (List<OrderDetails>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
