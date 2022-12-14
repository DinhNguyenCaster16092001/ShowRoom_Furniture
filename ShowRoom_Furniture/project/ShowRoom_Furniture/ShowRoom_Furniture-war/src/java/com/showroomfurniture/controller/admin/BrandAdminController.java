/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.admin;

import com.showroomfurniture.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/brand")
public class BrandAdminController {

    @Autowired
    private IBrandService iBrandService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String list(Model model) {
        model.addAttribute("brands", iBrandService.findAll());
        return "admin/brand/list";
    }
}
