/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.web;

import com.entity.Products;
import com.showroomfurniture.dto.ProductDTO;
import com.showroomfurniture.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String productPage(Model model, @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer categorid, @RequestParam(required = false) String title) {
        List<Products> result;
        result = iProductService.findAll(page, 6, categorid, title);
        Long totalProduct;
        if (title != null) {
            result = iProductService.findByTitle(title, page, 6);
            totalProduct = iProductService.coutAllByTitle(title);
            model.addAttribute("title", title);

        } else {
            totalProduct = iProductService.countAll(categorid, title);
        }
        if (categorid != null) {
            model.addAttribute("categorid", categorid);
        }

        model.addAttribute("products", result);
        model.addAttribute("totalPages", (int) Math.ceil((double) totalProduct / 6));
        System.out.println(result.size());
        model.addAttribute("page", page);
        return "web/product";
    }

    @RequestMapping("/details/{id}")
    public String productDetails(@PathVariable(value = "id") Integer id, Model model) {
        ProductDTO dto = iProductService.findAllById(id);
        if (dto != null) {
            List<Products> products = iProductService.findRandom5ProductByCategoryId(dto.getCategoryid(), dto.getId());
            model.addAttribute("product", dto);
            model.addAttribute("productsRelative", products);
        }
        return "web/product_details";
    }
}
