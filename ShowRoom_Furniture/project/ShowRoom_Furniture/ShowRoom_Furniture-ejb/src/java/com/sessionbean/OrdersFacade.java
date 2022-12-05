/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Orders;
import com.entity.Products;
import com.entity.Users;
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
public class OrdersFacade extends AbstractFacade<Orders> implements OrdersFacadeLocal {

    @PersistenceContext(unitName = "ShowRoom_Furniture-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }

    @Override
    public Orders findLastOrderByUserId(Users users) {
        try {
            Query query = em.createQuery("SELECT o FROM Orders o WHERE o.userid=:userid ORDER BY o.id DESC");
            query.setParameter("userid", users);
            query.setMaxResults(1);
            return (Orders) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Orders> findAllByUserId(Users users) {
        try {
            Query query = em.createQuery("SELECT o FROM Orders o WHERE o.userid=:userid ORDER BY o.id DESC");
            query.setParameter("userid", users);
            return (List<Orders>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
