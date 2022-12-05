/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service.impl;

import com.entity.Roles;
import com.entity.Users;
import com.sessionbean.UsersFacadeLocal;
import com.showroomfurniture.dto.UserDTO;
import com.showroomfurniture.service.IRoleService;
import com.showroomfurniture.service.IUserService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    UsersFacadeLocal usersFacade = lookupUsersFacadeLocal();

    @Autowired
    private IRoleService iRoleService;

    private UsersFacadeLocal lookupUsersFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (UsersFacadeLocal) c.lookup("java:global/ShowRoom_Furniture/ShowRoom_Furniture-ejb/UsersFacade!com.sessionbean.UsersFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public List<Users> findAll() {
        return usersFacade.findAll();
    }

    @Override
    public Users findById(Integer id) {
        return usersFacade.find(id);
    }

    private UserDTO _toUserDTO(Users user) {
        UserDTO dto = new UserDTO();
        if (user.getId() != null) {
            dto.setId(user.getId());
        }
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }

    private Users _toUserEnTity(UserDTO dto) {
        
        Users users = new Users();
        if (dto.getId() != null) {
            users.setId(dto.getId());
        }
        boolean isUpdateUser = (dto.getId() != null);
        if (isUpdateUser) {
            Users existingUser = findById(dto.getId());
            if (!dto.getPassword().equals(existingUser.getPassword()) && !dto.getPassword().isEmpty()) {
                String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
                users.setPassword(hashed);
            } else {
                users.setPassword(existingUser.getPassword());
            }
        } else {
            String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
            users.setPassword(hashed);
        }
        users.setEmail(dto.getEmail());
        users.setFirstName(dto.getFirstName());
        users.setLastName(dto.getLastName());
        Roles role = iRoleService.findById(dto.getRoleId());
        List<Roles> roles = new ArrayList<>();
        roles.add(role);
        users.setRolesList(roles);
        return users;
    }

    @Override
    public void save(UserDTO dto) {
        Users user = _toUserEnTity(dto);
        usersFacade.create(user);
    }

    @Override
    public boolean checkDuplicateEmail(String email, Integer id) {
        Users userByEmail = usersFacade.findByEmail(email);
        if (userByEmail == null) {
            return true;
        }

        boolean isCreateNew = (id == null);

        if (isCreateNew) {
            if (userByEmail != null) {
                return false;
            } else {
                if (userByEmail.getId() != id) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public UserDTO update(UserDTO dto) {
        Users user = _toUserEnTity(dto);
        usersFacade.edit(user);
        Users existingUser = findById(dto.getId());
        dto = _toUserDTO(user);
        return dto;
    }

    @Override
    public UserDTO getUserDTO(Integer id) {
        Users user = findById(id);
        UserDTO dto = _toUserDTO(user);
        return dto;
    }

    @Override
    public Users findByEmailAndPassword(String email, String password) {
        Users users = usersFacade.findByEmail(email);
        if (users != null) {
            System.out.println(users.toString());
            boolean checkPass = BCrypt.checkpw(password, users.getPassword());
            if (checkPass == true) {
                return users;
            } else {
                return null;
            }
        } else {
            System.out.println("Could not found user have email : " + email);
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
      Users users = usersFacade.find(id);
      usersFacade.remove(users);
    }

}
