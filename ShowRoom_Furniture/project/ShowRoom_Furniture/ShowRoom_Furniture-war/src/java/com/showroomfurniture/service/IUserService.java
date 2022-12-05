/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service;

import com.entity.Users;
import com.showroomfurniture.dto.UserDTO;
import java.util.List;

/**
 *
 * @author Nguyen Dinh
 */
public interface IUserService {

    List<Users> findAll();

    Users findById(Integer id);

    void save(UserDTO dto);

    boolean checkDuplicateEmail(String email, Integer id);

    UserDTO update(UserDTO dto);

    UserDTO getUserDTO(Integer id);
    
    Users findByEmailAndPassword(String email, String password);
    
    void delete(Integer id);
    
}
