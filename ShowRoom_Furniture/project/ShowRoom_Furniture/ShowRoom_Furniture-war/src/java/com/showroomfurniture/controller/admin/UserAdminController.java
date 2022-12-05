/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.admin;

import com.entity.Users;
import com.showroomfurniture.dto.UserDTO;
import com.showroomfurniture.service.IRoleService;
import com.showroomfurniture.service.IUserService;
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
@RequestMapping("/admin/user")
public class UserAdminController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("")
    public String listUser(Model model) {
        model.addAttribute("users", iUserService.findAll());
        return "admin/user/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showForm(Model model, @RequestParam(required = false) Integer id) {
        UserDTO user = null;
        model.addAttribute("roles", iRoleService.findAll());
        if (id == null) {
            model.addAttribute("user", user = new UserDTO());
        } else {
            model.addAttribute("user", user = iUserService.getUserDTO(id));
        }
        return "admin/user/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") UserDTO user, RedirectAttributes attributes) {
        System.out.println(user.toString());
        if (user.getId() == null) {
            iUserService.save(user);
            return "redirect:/admin/user";
        } else {
            UserDTO dto = iUserService.update(user);
            attributes.addFlashAttribute("message", "Bạn Đã Cập Nhật Thông Tin Thành Công");
            return "redirect:/admin/user/edit?id=" + dto.getId();
        }

    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
        iUserService.delete(id);
        attributes.addFlashAttribute("message", "Xoá thành công");
        return "redirect:/admin/user";
    }

}
