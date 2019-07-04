package net.suncaper.demo.controller;

import net.suncaper.demo.domain.Hotel;
import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// 确定订单页面
@Controller
@RequestMapping("/roomorder")
public class RoomOrderController {
    @Autowired
    private UserService userService;

    //
    @GetMapping
    public String getRegister(Model model) {
        model.addAttribute("", new User());
        return "/hotel_room_order.html";
    }

    @PostMapping
    public String saveUser(List<Hotel> d, Model model) {

        return "redirect:roomorder";

    }
}
