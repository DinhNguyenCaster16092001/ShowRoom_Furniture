/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.web;

import com.showroomfurniture.dto.UserDTO;
import com.showroomfurniture.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/register")
    public String regisertPage(Model model) {
        UserDTO userDTO = null;
        model.addAttribute("user", userDTO = new UserDTO());
        return "web/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String regisertPage(@ModelAttribute(value = "user") UserDTO userDTO, RedirectAttributes redirectAttributes) {
        System.out.println(userDTO.toString());
        userDTO.setRoleId(2);
        iUserService.save(userDTO);
        redirectAttributes.addFlashAttribute("message", "Đăng Kí Thành Công Hãy Đăng Nhập Để Tương Tác Với Chúng Tôi");
        return "redirect:/login";
    }
    
    
    

}
