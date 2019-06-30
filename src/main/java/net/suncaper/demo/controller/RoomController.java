package net.suncaper.demo.controller;

import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//详情页面控制器
@Controller
@RequestMapping("/register")
public class RoomController {
    @Autowired
    private UserService userService;

    //  显示搜索界面
    @GetMapping("/room")
    public String getRegister(Model model) {
        model.addAttribute("", new User());
        return "/register.html";
    }

    //待修改
    //从home接受信息传入此方法 并进行处理 显示在页面上
    @PostMapping("/room")
    public String saveUser(User user1, Model model) {

        return "redirect:register/room";

    }
}
