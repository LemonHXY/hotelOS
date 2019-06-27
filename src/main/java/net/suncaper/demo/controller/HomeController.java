package net.suncaper.demo.controller;

import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//主页控制器
//仅返回主页
@Controller
@RequestMapping({"index", "/"})
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String HomePage() {
        return "/index.html";
    }

}