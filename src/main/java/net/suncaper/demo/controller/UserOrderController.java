package net.suncaper.demo.controller;

import net.suncaper.demo.service.OrderServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


//用户订单管理
@Controller
@RequestMapping({"/userorder"})
public class UserOrderController {
    @Autowired
    private OrderServicelmpl orderServicelmpl;

    //显示订单界面
    @GetMapping
    public String SearchPage(Model model, HttpServletRequest request) {
        Cookie[] cookies=request.getCookies();
        int uId = 1;
        for (Cookie cookie:cookies)
        {
            if(cookie.getName().equals("uId"))
            {
                uId=Integer.parseInt(cookie.getValue());
            }
        }
       model.addAttribute("orders", orderServicelmpl.GetOrderLists(uId));
        return "/user_order.html";
    }

    @PostMapping("/detail")
    public String OrderDetail(Model model,HttpServletRequest request) {
        int oId=Integer.parseInt(request.getQueryString());

        return null;
    }
}
