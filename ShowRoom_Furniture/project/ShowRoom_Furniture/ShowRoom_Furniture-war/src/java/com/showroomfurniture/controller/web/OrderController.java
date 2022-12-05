/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.web;

import com.entity.OrderDetails;
import com.entity.OrderDetailsPK;
import com.entity.Orders;
import com.entity.Users;
import com.showroomfurniture.dto.CartDTO;
import com.showroomfurniture.dto.OrderDetailsDTO;
import com.showroomfurniture.service.IOrderDetailService;
import com.showroomfurniture.service.IOrderService;
import com.showroomfurniture.service.IUserService;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IOrderDetailService iOrderDetailService;

    @RequestMapping(value = "/checkOut", method = RequestMethod.POST)
    public String checkOut(HttpSession session, @RequestParam("shipAddress") String shipAddress, @RequestParam("numberPhone") String numberPhone) {
        Integer totalPrice = (Integer) session.getAttribute("cartTotal");
        HashMap<Integer, CartDTO> cartItems = (HashMap<Integer, CartDTO>) session.getAttribute("cartItems");
        Users users = (Users) session.getAttribute("user");
        //Create instance Orders
        Orders orders = new Orders();
        orders.setStatus(1);
        orders.setTotal(BigDecimal.valueOf(totalPrice));
        Users userDatabase = iUserService.findById(users.getId());
        orders.setUserid(userDatabase);
        orders.setShipAddress(shipAddress);
        orders.setNumberPhone(numberPhone);

        //save Orders
        iOrderService.save(orders);

        Orders lastOrders = iOrderService.findLastOrderByUserId(userDatabase.getId());

        for (Map.Entry<Integer, CartDTO> entry : cartItems.entrySet()) {
            OrderDetails orderDetail = new OrderDetails();
            orderDetail.setOrderDetailsPK(new OrderDetailsPK(lastOrders.getId(), entry.getValue().getProductDTO().getId()));
            orderDetail.setQuantity(entry.getValue().getQuantity());
            iOrderDetailService.save(orderDetail);
        }

        session.removeAttribute("cartTotal");
        session.removeAttribute("cartItems");
        session.removeAttribute("cartNum");
        return "redirect:/order/success";
    }

    @RequestMapping("/success")
    public String checkOutSuccess(Model model, HttpSession session) {
        Users users = (Users) session.getAttribute("user");
        model.addAttribute("user", users);
        return "web/checkout_success";
    }

    @RequestMapping("/{userid}")
    public String listOrders(Model model, @PathVariable(value = "userid") Integer userId) {
        List<Orders> list = iOrderService.findAllByUserId(userId);
        model.addAttribute("orders", list);
        return "web/list_order";
    }

    @RequestMapping("/detail/{orderid}")
    public String checkOutSuccess(Model model, @PathVariable(value = "orderid") Integer orderid) {
        List<OrderDetails> list = iOrderDetailService.findAllByOrderId(orderid);
        model.addAttribute("orderDetails", list);
        return "web/order_details";
    }
}
