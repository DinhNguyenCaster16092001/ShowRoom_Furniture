/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.service;

import com.entity.OrderDetails;
import com.showroomfurniture.dto.OrderDetailsDTO;
import java.util.List;

public interface IOrderDetailService {

    void save(OrderDetails orderDetails);

    List<OrderDetails> findAllByOrderId(Integer orderId);
}
