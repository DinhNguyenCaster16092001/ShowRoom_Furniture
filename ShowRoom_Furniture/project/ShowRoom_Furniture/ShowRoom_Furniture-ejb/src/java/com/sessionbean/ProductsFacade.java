/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionbean;

import com.entity.Brands;
import com.entity.Categories;
import com.entity.Categories_;
import com.entity.Products;
import com.entity.Products_;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Nguyen Dinh
 */
@Stateless
public class ProductsFacade extends AbstractFacade<Products> implements ProductsFacadeLocal {

    @PersistenceContext(unitName = "ShowRoom_Furniture-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ProductsFacade() {
        super(Products.class);
    }

    @Override
    public List<Products> find8NewProduct() {
        try {
            Query query = em.createQuery("SELECT p FROM Products p ORDER BY p.id DESC");
            query.setFirstResult(0);
            query.setMaxResults(8);
            return (List<Products>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Products> findAll(Integer page, Integer pageSize, Integer categoryId, String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Products> criteriaQuery = cb.createQuery(Products.class);
        Root<Products> root = criteriaQuery.from(Products.class);
        criteriaQuery.select(root);
        criteriaQuery.orderBy(cb.desc(root.get(Products_.id)));
        List<Predicate> predicatesList = new ArrayList<>();

        if (categoryId != null) {
            predicatesList.add(
                    cb.equal(root.get(Products_.categoryid).get(Categories_.id), categoryId));
        }

        if (title != null) {
            predicatesList.add(cb.like(root.get("title").as(String.class), title));
        }

        if (!predicatesList.isEmpty()) {
            Predicate[] finalPredicates = new Predicate[predicatesList.size()];
            predicatesList.toArray(finalPredicates);
            criteriaQuery.where(finalPredicates);
        }
        List<Products> result
                = em.createQuery(criteriaQuery)
                        .setMaxResults(pageSize)
                        .setFirstResult(page)
                        .getResultList();

        return result;
    }

    @Override
    public Long countAll(Integer categoryId, String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
        Root<Products> root = criteriaQuery.from(Products.class);
        CriteriaQuery<Long> select = criteriaQuery.select(cb.count(root));
        List<Predicate> predicatesList = new ArrayList<>();

        if (categoryId != null) {
            predicatesList.add(
                    cb.equal(root.get(Products_.categoryid).get(Categories_.id), categoryId));
        }

        if (title != null) {
            predicatesList.add(cb.like(root.get("title").as(String.class), "%" + title + "%"));
        }

        if (!predicatesList.isEmpty()) {
            Predicate[] finalPredicates = new Predicate[predicatesList.size()];
            predicatesList.toArray(finalPredicates);
            criteriaQuery.where(finalPredicates);
        }

        TypedQuery<Long> tq = em.createQuery(select);
        Long result = tq.getSingleResult();
        return result;
    }

    @Override
    public List<Products> findByTitle(String title, Integer page, Integer pageSize) {
        try {
            Query query = em.createQuery("SELECT p FROM Products p WHERE p.title like lower(:title)");
            query.setParameter("title", "%" + title + "%");
            query.setFirstResult(page);
            query.setMaxResults(pageSize);
            return (List<Products>) query.getResultList();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Products> findRandom5ByCategoryId(Categories categories, Integer id) {
        try {
            Query countQuery = em.createQuery("select count(p) from Products p WHERE p.categoryid=:categoryid AND NOT p.id =:id");
            countQuery.setParameter("categoryid", categories);
            countQuery.setParameter("id", id);
            int count = ((Number) countQuery.getSingleResult()).intValue();

            Random random = new Random();
            
            int number = random.nextInt(Math.abs(count));

            Query selectQuery = em.createQuery("select p from Products p WHERE p.categoryid=:categoryid AND NOT p.id =:id");
            selectQuery.setParameter("categoryid", categories);
            selectQuery.setParameter("id", id);
            selectQuery.setFirstResult(number);
            selectQuery.setMaxResults(3);
            return (List<Products>) selectQuery.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Products> findProductByBrandId(Brands brands) {
        try {
            Query query = em.createQuery("SELECT p FROM Products p WHERE p.brandid=:brandid ORDER BY p.id DESC");
            query.setParameter("brandid", brands);
            query.setFirstResult(0);
            query.setMaxResults(3);
            return (List<Products>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Long countAll(String title) {
        Query query = em.createQuery("SELECT COUNT(p) FROM Products p WHERE p.title like lower(:title)");
        query.setParameter("title", "%" + title + "%");
        return (Long) query.getSingleResult();
    }

}
