package net.suncaper.demo.controller;

import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//登陆控制器
//已实现
@Controller
@RequestMapping({"enter"})
public class EnterController {
    @Autowired
    private UserService userService;


    @GetMapping
    public String userPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("msg1", "欢迎登陆");
        return "/enter.html";
    }

    //接受登录信息并进行处理
    @PostMapping("/login")
    public String greetingSubmit(User user1, Model model) {
        User user = userService.findUserByUIid(user1.getuId());
        if (user != null && user.getuPassword() == user1.getuPassword())
            return "redirect:/index";
        else {
            model.addAttribute("user", new User());
            model.addAttribute("msg1", "密码错误");
            return "/enter.html";
        }
    }
}