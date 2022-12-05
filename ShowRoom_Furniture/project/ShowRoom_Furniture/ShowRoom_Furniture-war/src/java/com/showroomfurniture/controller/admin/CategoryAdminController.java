/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.admin;

import com.entity.Categories;
import com.showroomfurniture.service.ICategoryService;
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
@RequestMapping("/admin/category")
public class CategoryAdminController {

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String list(Model model) {
        model.addAttribute("categories", iCategoryService.findAll());
        return "admin/category/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    public String showForm(@RequestParam(required = false) Integer id, Model model, RedirectAttributes redirectAttributes) {
        Categories category = null;
        if (id == null) {
            model.addAttribute("category", category = new Categories());
        } else {
            category = iCategoryService.findById(id);
            if (category != null) {
                model.addAttribute("category", category);
            } else {
                redirectAttributes.addFlashAttribute("message", "Cannot found category have id: " + id);
                redirectAttributes.addFlashAttribute("alert", "danger");
                return "redirect:/admin/category/";
            }
        }
        return "admin/category/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute("category") Categories categories, Model model, RedirectAttributes redirectAttributes) {
        if (categories.getId() != null) {
            Categories saveCategories = iCategoryService.edit(categories);
            String url = "";
            if (saveCategories != null) {
                redirectAttributes.addFlashAttribute("message", "Update Success");
                redirectAttributes.addFlashAttribute("alert", "success");
                url = "redirect:/admin/category/edit?id=" + saveCategories.getId();
            }
            return url;
        } else {
            iCategoryService.save(categories);
            redirectAttributes.addFlashAttribute("message", "Adding success new category");
            redirectAttributes.addFlashAttribute("alert", "success");
            return "redirect:/admin/category/";
        }

    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        iCategoryService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete success category");
        redirectAttributes.addFlashAttribute("alert", "success");
        return "redirect:/admin/category/";
    }

}
