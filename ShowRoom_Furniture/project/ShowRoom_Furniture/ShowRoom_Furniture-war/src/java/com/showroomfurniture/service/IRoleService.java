/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service;

import com.entity.Roles;
import java.util.List;


public interface IRoleService {
    List<Roles> findAll();
    Roles findById(Integer id);
}
