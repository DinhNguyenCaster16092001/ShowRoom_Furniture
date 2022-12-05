/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.dto;

public class UserDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Integer roleId;

    public UserDTO() {
    }
    
    

    public UserDTO(String firstName, String lastName, String email, String password, Integer roleId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public UserDTO(Integer id, String firstName, String lastName, String email, String password, Integer roleId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", roleId=" + roleId + '}';
    }

}
