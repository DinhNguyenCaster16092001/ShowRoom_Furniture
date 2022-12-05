/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.rest;

import com.entity.Users;
import com.showroomfurniture.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class ApiUserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "", //
            method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Users> getUsers() {
        List<Users> users = iUserService.findAll();
        return users;
    }

    @RequestMapping(value = "/checkEmail", //
            method = RequestMethod.GET)
    @ResponseBody
    public String checkDuplicateUser(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "email", required = false) String email) {
        return iUserService.checkDuplicateEmail(email, id) ? "OK" : "Duplicated";
    }
}
