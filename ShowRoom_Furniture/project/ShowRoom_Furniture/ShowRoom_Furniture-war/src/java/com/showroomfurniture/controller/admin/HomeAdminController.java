/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.admin;

import com.entity.Users;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(HttpSession session) {
        Users users = (Users) session.getAttribute("user");
        if (users != null) {
            if (users.getRolesList().get(0).getId() == 1) {
                return "admin/home";
            } else {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }

    }
}
