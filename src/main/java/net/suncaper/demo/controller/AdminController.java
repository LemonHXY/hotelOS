package net.suncaper.demo.controller;

import net.suncaper.demo.domain.OrderOutput;
import net.suncaper.demo.domain.R_order;
import net.suncaper.demo.domain.R_orderExample;
import net.suncaper.demo.mapper.R_orderMapper;
import net.suncaper.demo.service.OrderService;
import net.suncaper.demo.service.OrderServicelmpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.*;

import javax.servlet.http.*;
import java.util.List;


// 系统管理员控制模块
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderServicelmpl orderServicelmpl;
    @Autowired
    private R_orderMapper r_orderMapper;
    @Autowired
    private OrderService orderService;

    // 默认跳转到管理员登陆界面
    @GetMapping
    public String AdminEnter(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if ((cookies != null)) {//判断Cookie是否为空
            for (Cookie cookie : cookies) {//遍历Cookie判断有没有对应的name
                if (cookie.getValue().equals("uId")) {//有就直接return true
                    return "redirect:/index";
                }
            }
        }
        model.addAttribute("user", new User());
        model.addAttribute("msg1", "欢迎登陆");

        return "/admin_enter.html";
    }

    // 登陆实现 添加cookie
    @PostMapping
    public String EnterControl(User user1, Model model, HttpServletResponse response) {
        // 只有id匹配1的用户（管理员）能够登陆
        User user = userService.findUserByUIid(1);
        if (user1.getuId() == 1 && user.getuPassword().equals(user1.getuPassword())) {
            String userId = user1.getuId().toString();
            Cookie cookie = new Cookie("uId", userId);
            Cookie cookie1 = new Cookie("uName", user.getuName());

            cookie.setPath("/");
            cookie1.setPath("/");

            // 将cookie加入后直接返回订单界面
            response.addCookie(cookie);
            response.addCookie(cookie1);

            return "redirect:/admin/order";

        } else {
            model.addAttribute("user", new User());
            model.addAttribute("msg1", "非管理员用户或密码错误");
            return "/admin_enter.html";
        }


    }

    // 后台订单管理界面
    @GetMapping("/order")
    public String AdminOrder(User user1, Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if ((cookies != null)) {// 如果登录信息不为空则返回所有订单
            for (Cookie cookie : cookies)
                if (cookie.getValue().equals("1")) {
                    model.addAttribute("orders", orderServicelmpl.GetAllOrderOutput());
                    return "/admin_order.html";
                }
        }
        // 登陆信息为空则返回空的订单列表
        model.addAttribute("orders", orderServicelmpl.GetOrderLists(0));
        return "/admin_order.html";
    }

    // 所有订单详情页面
    @GetMapping("/orderdetail")
    public String AdminOrderDetail(Model model, HttpServletRequest request) {
        int oId = Integer.parseInt(request.getQueryString());
        OrderOutput orderOutput = orderService.GetOrderLists2(oId);
        model.addAttribute("orderOutput", orderOutput);
        return "/admin_order_detail.html";
    }

    // 退房信息页面
    @GetMapping("/checkoutlist")
    public String AdminCheckOut(User user1, Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if ((cookies != null)) {// 如果登录信息不为空则返回所有订单
            for (Cookie cookie : cookies)
                if (cookie.getValue().equals("1")) {
                    model.addAttribute("orders", orderServicelmpl.GetAllByCheckOut());
                    return "/admin_order.html";
                }
        }
        // 登陆信息为空则返回空的订单列表
        model.addAttribute("orders", orderServicelmpl.GetOrderLists(0));
        return "/admin_check_out.html";
    }

    // 用户管理页面
    @GetMapping("/user")
    public String AdminUser() {
        return "/admin_user.html";
    }


}
