package net.suncaper.demo.controller;

import net.suncaper.demo.service.OrderServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


//用户订单管理页面
@Controller
@RequestMapping({"userorder"})
public class UserOrderController {
    @Autowired
    private OrderServicelmpl orderServicelmpl;

    //显示订单界面
    @GetMapping("/get")
    public String SearchPage(Model model, HttpServletRequest request) {
        Cookie[] cookies=request.getCookies();
        int oId = 1;
        for (Cookie cookie:cookies)
        {
            if(cookie.getName().equals("uId"))
            {
                oId=Integer.parseInt(cookie.getValue());
            }
        }
       model.addAttribute("orders", orderServicelmpl.GetOrderLists(oId));


        return "/user_order.html";
    }

}
