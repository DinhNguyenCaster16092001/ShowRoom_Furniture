/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.showroomfurniture.controller.web;

import com.entity.Users;
import com.showroomfurniture.dto.CartDTO;
import com.showroomfurniture.dto.ProductDTO;
import com.showroomfurniture.service.IProductService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String cartPage(HttpSession session) {
        HashMap<Integer, CartDTO> cartItems = (HashMap<Integer, CartDTO>) session.getAttribute("cartItems");
        Users users = (Users) session.getAttribute("user");
        if (users == null) {
            return "redirect:/login";
        } else {
            if (cartItems == null) {
                cartItems = new HashMap<>();
            }
            session.setAttribute("cartItems", cartItems);
            return "web/cart";
        }

    }

    @RequestMapping("/add/{id}")
    public String addItemCart(HttpSession session, @PathVariable Integer id, @RequestParam(value = "qty", required = false) Integer qty) {
        HashMap<Integer, CartDTO> cartItems = (HashMap<Integer, CartDTO>) session.getAttribute("cartItems");

        Users users = (Users) session.getAttribute("user");
        if (users == null) {
            return "redirect:/login";
        } else {
            if (cartItems == null) {
                cartItems = new HashMap<>();
                ProductDTO productDTO = iProductService.findAllById(id);
                if (productDTO != null) {
                    if (cartItems.containsKey(id)) {
                        CartDTO item = cartItems.get(id);
                        item.setProductDTO(productDTO);
                        if (qty != null) {
                            item.setQuantity(item.getQuantity() + qty);
                        } else {
                            item.setQuantity(item.getQuantity() + 1);
                        }
                        cartItems.put(id, item);
                    } else {
                        CartDTO item = new CartDTO();
                        item.setProductDTO(productDTO);
                        if (qty != null) {
                            item.setQuantity(qty);
                        } else {
                            item.setQuantity(1);
                        }

                        cartItems.put(id, item);
                    }
                }
                session.setAttribute("cartItems", cartItems);
                session.setAttribute("cartTotal", totalPrice(cartItems));
                session.setAttribute("cartNum", cartItems.size());
                return "web/cart";
            }

            ProductDTO productDTO = iProductService.findAllById(id);
            if (productDTO != null) {
                if (cartItems.containsKey(id)) {
                    CartDTO item = cartItems.get(id);
                    item.setProductDTO(productDTO);
                    if (qty != null) {
                        item.setQuantity(item.getQuantity() + qty);
                    } else {
                        item.setQuantity(item.getQuantity() + 1);
                    }
                    cartItems.put(id, item);
                } else {
                    CartDTO item = new CartDTO();
                    item.setProductDTO(productDTO);
                    if (qty != null) {
                        item.setQuantity(qty);
                    } else {
                        item.setQuantity(1);
                    }

                    cartItems.put(id, item);
                }
            }
            session.setAttribute("cartItems", cartItems);
            session.setAttribute("cartTotal", totalPrice(cartItems));
            session.setAttribute("cartNum", cartItems.size());
            return "web/cart";
        }
    }

    @RequestMapping("/update/{id}")
    public String updateItemCart(HttpSession session, @PathVariable Integer id, @RequestParam(value = "qty", required = false) Integer qty) {
        HashMap<Integer, CartDTO> cartItems = (HashMap<Integer, CartDTO>) session.getAttribute("cartItems");
        Users users = (Users) session.getAttribute("user");
        if (users == null) {
            return "redirect:/login";
        } else {
            if (cartItems == null) {
                cartItems = new HashMap<>();
            }
            ProductDTO productDTO = iProductService.findAllById(id);
            if (productDTO != null) {
                if (cartItems.containsKey(id)) {
                    CartDTO item = cartItems.get(id);
                    item.setProductDTO(productDTO);
                    item.setQuantity(qty);
                    cartItems.put(id, item);
                } else {
                    CartDTO item = new CartDTO();
                    item.setProductDTO(productDTO);
                    item.setQuantity(1);
                    cartItems.put(id, item);
                }
            }
            session.setAttribute("cartItems", cartItems);
            session.setAttribute("cartTotal", totalPrice(cartItems));
            session.setAttribute("cartNum", cartItems.size());
            return "web/cart";
        }
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String viewRemove(HttpSession session, @PathVariable("id") Integer id) {
        HashMap<Integer, CartDTO> cartItems = (HashMap<Integer, CartDTO>) session.getAttribute("cartItems");
        Users users = (Users) session.getAttribute("user");
        if (users == null) {
            return "redirect:/login";
        } else {
            if (cartItems == null) {
                cartItems = new HashMap<>();
            }
            if (cartItems.containsKey(id)) {
                cartItems.remove(id);
            }
            session.setAttribute("cartItems", cartItems);
            session.setAttribute("cartTotal", totalPrice(cartItems));
            session.setAttribute("cartNum", cartItems.size());
            return "web/cart";
        }
    }

    public int totalPrice(HashMap<Integer, CartDTO> cartItems) {
        int count = 0;
        for (Map.Entry<Integer, CartDTO> list : cartItems.entrySet()) {
            count += (list.getValue().getProductDTO().getPrice().intValue()) * list.getValue().getQuantity();
        }
        return count;
    }
}
