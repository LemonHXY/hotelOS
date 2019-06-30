package net.suncaper.demo.controller;

import net.suncaper.demo.domain.OrderOutput;
import net.suncaper.demo.mapper.HotelMapper;
import net.suncaper.demo.mapper.R_orderMapper;
import net.suncaper.demo.mapper.RoomMapper;
import net.suncaper.demo.service.OrderService;
import net.suncaper.demo.service.OrderServicelmpl;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//用户订单管理
@Controller
@RequestMapping({"userorder"})
public class UserOrderController {
    @Autowired
    private OrderServicelmpl orderServicelmpl;

    //显示订单界面
    @GetMapping("/get")
    public String SearchPage(Model model) {
        int oId = 1;
        orderServicelmpl.GetOrderLists(oId);


        return "/user_order.html";
    }

}
