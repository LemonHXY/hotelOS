package net.suncaper.demo.controller;

import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//注册控制器
@Controller
@RequestMapping({"room"})
public class RoomController {
    @Autowired
    private UserService userService;

    //  显示注册页面
    @GetMapping("/get")
    public String SearchPage(Model model) {
        model.addAttribute("user",new User());
        return "/hotel_room.html";
    }

    //待修改
    //从home接受信息传入此方法 并进行处理 显示在页面上
    @PostMapping("/post")
    public String greetingSubmit(User user1, Model model) {
        return "redirect:/search/get";
    }
}
