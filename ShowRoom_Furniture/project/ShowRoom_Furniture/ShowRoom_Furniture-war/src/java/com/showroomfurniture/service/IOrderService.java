/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service;

import com.entity.Orders;
import java.util.List;

public interface IOrderService {

    void save(Orders orders);

    Orders findLastOrderByUserId(Integer userId);

    List<Orders> findAllByUserId(Integer userId);
    
    List<Orders> findAll();
    
    void update(Integer id);
}
