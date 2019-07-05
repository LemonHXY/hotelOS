package net.suncaper.demo.controller;

import net.suncaper.demo.domain.OrderOutput;
import net.suncaper.demo.mapper.R_orderMapper;
import net.suncaper.demo.service.OrderService;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

//从用户订单列表进入的订单详情页面
@Controller
@RequestMapping("/orderdetail")
public class UserOrderDetailController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private R_orderMapper r_orderMapper;

    //
    @GetMapping("/detail")
    public String getDetail(Model model, HttpServletRequest request) {
        int temp=Integer.parseInt(request.getQueryString());
        int oId=(int) temp;
        OrderOutput orderOutput = orderService.GetOrderLists2(oId);
        model.addAttribute("orderOutput", orderOutput);
        return "/user_order_detail.html";
    }


    @GetMapping("/checkout")
    public String checkOut(Model model, HttpServletRequest request) {
        int oId = Integer.parseInt(request.getQueryString());
        r_orderMapper.updateStatus(oId);

        return "redirect:/userorder";
    }

    @GetMapping("/delete")
    public String delete(Model model, HttpServletRequest request) {
        int oId=(int)Integer.parseInt(request.getQueryString());
        OrderOutput orderOutput = orderService.GetOrderLists2(oId);
        model.addAttribute("orderOutput", orderOutput);
        return "/user_order_detail.html";
    }
}