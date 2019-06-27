package net.suncaper.demo.controller;

import net.suncaper.demo.domain.User;
import net.suncaper.demo.mapper.UserMapper;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//注册控制器
@Controller
@RequestMapping({"register"})
public class RegisterController {
    @Autowired
    private UserService userService;

    //显示注册页面
    @GetMapping("/get")
    public String RegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

    //待修改
    //从home接受信息传入此方法 并进行处理 显示在页面上
    @PostMapping("/post")
    public String SaveUser(User user, Model model) {
        model.addAttribute("user", new User());
        userService.saveUser(user);
        return "redirect:/userorder/get";
    }
}
