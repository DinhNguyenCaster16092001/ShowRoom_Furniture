/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Users;
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
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    @PersistenceContext(unitName = "ShowRoom_Furniture-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public Users findByEmail(String email) {
        try {
            Query query = em.createQuery("select u from Users u where u.email=:email");
            query.setParameter("email", email);
            return (Users) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    

}
