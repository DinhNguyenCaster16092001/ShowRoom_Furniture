/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.admin;

import com.entity.Brands;
import com.entity.Categories;
import com.showroomfurniture.dto.ProductDTO;
import com.showroomfurniture.service.IBrandService;
import com.showroomfurniture.service.ICategoryService;
import com.showroomfurniture.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    IBrandService iBrandService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listProduct(Model model) {
        model.addAttribute("products", iProductService.findAll());
        return "admin/product/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showForm(Model model, @RequestParam(required = false) Integer id) {
        ProductDTO productDTO = null;
        List<Categories> categorieses = iCategoryService.findAll();
        List<Brands> brands = iBrandService.findAll();
        if (id == null) {
            model.addAttribute("product", productDTO = new ProductDTO());
        } else {
            productDTO = iProductService.findAllById(id);
            System.out.println(productDTO.toString());
            model.addAttribute("product", productDTO);
        }
        model.addAttribute("categories", categorieses);
        model.addAttribute("brands", brands);
        return "admin/product/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute("product") ProductDTO productDTO, Model model, RedirectAttributes attributes) {

        if (productDTO.getId() == null) {
            productDTO.setStatus(1);
            iProductService.save(productDTO);
            return "redirect:/admin/product";
        } else {
            ProductDTO saveDto = iProductService.edit(productDTO);
            attributes.addFlashAttribute("message", "Cập Nhật Thành Công Sản Phẩm");
            return "redirect:/admin/product/edit?id=" + saveDto.getId();
        }
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        iProductService.delete(id);
        return "redirect:/admin/product";
    }

}
