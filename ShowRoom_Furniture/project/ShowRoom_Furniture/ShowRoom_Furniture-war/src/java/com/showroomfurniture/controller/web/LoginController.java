/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.web;

import com.entity.Users;
import com.showroomfurniture.service.IUserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/login")
    public String loginPage() {
        return "web/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginProccess(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) {
        Users users = iUserService.findByEmailAndPassword(email, password);
        if (users != null) {
            session.setAttribute("user", users);
            if (users.getRolesList().get(0).getId() == 1) {
                return "redirect:/admin";
            } else {
                return "redirect:/";
            }
        } else {
            System.out.println("Login failed");
            return "web/login";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirect) {
        session.invalidate();
        redirect.addFlashAttribute("message", "Bạn Đã Đăng Xuất");
        return "redirect:/login";
    }
}
