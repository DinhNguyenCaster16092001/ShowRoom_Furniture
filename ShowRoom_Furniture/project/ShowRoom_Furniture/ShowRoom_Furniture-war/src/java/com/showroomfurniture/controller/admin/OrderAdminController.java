/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.admin;

import com.entity.OrderDetails;
import com.showroomfurniture.service.IOrderDetailService;
import com.showroomfurniture.service.IOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/order")
public class OrderAdminController {

    @Autowired
    private IOrderService iOrderService;

    private IOrderDetailService iOrderDetailService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("orders", iOrderService.findAll());
        return "admin/order/list";
    }

    @RequestMapping(value = "update/{orderid}", method = RequestMethod.GET)
    public String updateOrder(Model model, @PathVariable("orderid") Integer orderId, RedirectAttributes attributes) {
        iOrderService.update(orderId);
        attributes.addFlashAttribute("message", "Đã Xác Nhận Đơn Hàng Thành Công");
        return "redirect:/admin/order";
    }

    @RequestMapping(value = "details/{orderid}", method = RequestMethod.GET)
    public String orderDetails(Model model, @PathVariable("orderid") Integer orderId, RedirectAttributes attributes) {
        List<OrderDetails> list = iOrderDetailService.findAllByOrderId(orderId);
        model.addAttribute("list", list);
        return "admin/order/details";
    }

}
