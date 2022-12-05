/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.web;

import com.entity.Products;
import com.showroomfurniture.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("eradoProducts", iProductService.findAllByBrandId(3));
        model.addAttribute("hoaPhatProducts", iProductService.findAllByBrandId(2));
        model.addAttribute("decorProducts", iProductService.findAllByBrandId(4));
        model.addAttribute("newProducts", iProductService.find8NewProduct());
        return "web/home";
    }

    @RequestMapping("/about")
    public String aboutUs() {
        return "web/about_us";
    }

}
