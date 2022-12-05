/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service.impl;

import com.entity.Brands;
import com.entity.Categories;
import com.entity.Products;
import com.sessionbean.BrandsFacadeLocal;
import com.sessionbean.CategoriesFacadeLocal;
import com.sessionbean.ProductsFacadeLocal;
import com.showroomfurniture.dto.ProductDTO;
import com.showroomfurniture.service.IBrandService;
import com.showroomfurniture.service.ICategoryService;
import com.showroomfurniture.service.IProductService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements IProductService {

    BrandsFacadeLocal brandsFacade = lookupBrandsFacadeLocal();

    CategoriesFacadeLocal categoriesFacade = lookupCategoriesFacadeLocal();

    ProductsFacadeLocal productsFacade = lookupProductsFacadeLocal();

    private CategoriesFacadeLocal lookupCategoriesFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CategoriesFacadeLocal) c.lookup("java:global/ShowRoom_Furniture/ShowRoom_Furniture-ejb/CategoriesFacade!com.sessionbean.CategoriesFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ProductsFacadeLocal lookupProductsFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (ProductsFacadeLocal) c.lookup("java:global/ShowRoom_Furniture/ShowRoom_Furniture-ejb/ProductsFacade!com.sessionbean.ProductsFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBrandService iBrandService;

    @Override
    public List<Products> findAll() {
        return productsFacade.findAll();
    }

    @Override
    public ProductDTO findAllById(Integer id) {
        Products products = productsFacade.find(id);
        ProductDTO dto = _toConvertProductDTO(products);
        return dto;
    }

    @Override
    @Transactional
    public void save(ProductDTO dto) {
        Products products = _toConvertProductEntity(dto);
        productsFacade.create(products);
    }

    public ProductDTO edit(ProductDTO dto) {
        Products products = _toConvertProductEntity(dto);
        productsFacade.edit(products);
        return findAllById(products.getId());
    }

    private Products _toConvertProductEntity(ProductDTO dto) {
        Products products = new Products();
        if (dto.getId() != null) {
            products.setId(dto.getId());
        }
        products.setTitle(dto.getTitle());
        products.setPrice(dto.getPrice());
        products.setQuantity(dto.getQuantity());
        products.setImage(dto.getImage());
        products.setShortDescription(dto.getShortDescription());
        products.setDescription(dto.getDescription());
        products.setStatus(dto.getStatus());
        products.setSubstance(dto.getSubstance());
        Categories category = iCategoryService.findById(dto.getCategoryid());
        Brands brand = iBrandService.findById(dto.getBrandid());
        products.setBrandid(brand);
        products.setCategoryid(category);
        return products;
    }

    private ProductDTO _toConvertProductDTO(Products products) {
        ProductDTO dto = new ProductDTO();
        dto.setId(products.getId());
        dto.setTitle(products.getTitle());
        dto.setPrice(products.getPrice());
        dto.setQuantity(products.getQuantity());
        dto.setImage(products.getImage());
        dto.setShortDescription(products.getShortDescription());
        dto.setStatus(products.getStatus());
        dto.setDescription(products.getDescription());
        dto.setSubstance(products.getSubstance());
        dto.setBrandid(products.getBrandid().getId());
        dto.setCategoryid(products.getCategoryid().getId());
        dto.setCategoryName(products.getCategoryid().getName());
        dto.setBrandName(products.getBrandid().getName());
        return dto;
    }

    @Override
    public void delete(Integer id) {
        Products products = productsFacade.find(id);
        productsFacade.remove(products);
    }

    @Override
    public List<Products> find8NewProduct() {
        return productsFacade.find8NewProduct();
    }

    @Override
    public List<Products> findAll(Integer page, Integer pageSize, Integer categoryId, String title) {
        if (page == null) {
            page = 1;
        }
        Integer offset = (page - 1) * pageSize;
        return productsFacade.findAll(offset, pageSize, categoryId, title);
    }

    @Override
    public Long countAll(Integer categoryId, String title) {
        return productsFacade.countAll(categoryId, title);
    }

    @Override
    public List<Products> findByTitle(String title, Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        Integer offset = (page - 1) * pageSize;
        return productsFacade.findByTitle(title, offset, pageSize);
    }

    @Override
    public List<Products> findRandom5ProductByCategoryId(Integer categoryId, Integer id) {
        Categories categories = categoriesFacade.find(categoryId);
        return productsFacade.findRandom5ByCategoryId(categories, id);
    }

    @Override
    public List<Products> findAllByBrandId(Integer id) {
        Brands brands = brandsFacade.find(id);
        return productsFacade.findProductByBrandId(brands);
    }

    @Override
    public Long coutAllByTitle(String title) {
        return productsFacade.countAll(title);
    }

}
