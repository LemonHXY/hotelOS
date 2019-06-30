package net.suncaper.demo.controller;

import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//详情页面控制器
@Controller
@RequestMapping("/orderdetail")
public class UserOrderDetailController {
    @Autowired
    private UserService userService;

    //
    @GetMapping("/get")
    public String getRegister(Model model) {
        model.addAttribute("", new User());
        return "/user_order_detail.html";
    }

    //待修改
    //从home接受信息传入此方法 并进行处理 显示在页面上
    @PostMapping("/get")
    public String saveUser(List<Hotel> d, Model model) {

        return "redirect:orderdetail/get";

    }
}