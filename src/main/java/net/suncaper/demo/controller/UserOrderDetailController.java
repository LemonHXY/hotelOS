package net.suncaper.demo.controller;

import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.OrderOutput;
import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.HotelService;
import net.suncaper.demo.service.OrderService;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//从用户订单列表进入的订单详情页面
@Controller
@RequestMapping("/orderdetail")
public class UserOrderDetailController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    //
    @GetMapping("/detail")
    public String getDetail(Model model, HttpServletRequest request) {
        int oId=Integer.parseInt(request.getQueryString());
        OrderOutput orderOutput = orderService.GetOrderLists2(oId);
        model.addAttribute("orderOutput", orderOutput);
        return "/user_order_detail.html";
    }


    @GetMapping("/delete")
    public String delete(Model model, HttpServletRequest request) {
        int oId=Integer.parseInt(request.getQueryString());
        OrderOutput orderOutput = orderService.GetOrderLists2(oId);
        model.addAttribute("orderOutput", orderOutput);
        return "/user_order_detail.html";
    }
}