package net.suncaper.demo.controller;

import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//注册控制器
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    //  显示搜索界面
    @GetMapping
    public String getRegister(Model model) {
        model.addAttribute("msg1","注册后不可修改");
        model.addAttribute("user",new User());
        return "/register.html";
    }

    //待修改
    //从home接受信息传入此方法 并进行处理 显示在页面上
    @PostMapping
    public String saveUser(User user1, Model model) {

        model.addAttribute("user",new User());
        User temp=userService.findUserByUIid(user1.getuId());
        if(temp==null)
        {
            user1.setUstatus("正常");
            userService.saveUser(user1);
            return "redirect:/enter";
        }
        else
        {
            model.addAttribute("msg1","该id已被使用");
            model.addAttribute("user",new User());
            return "/register.html";
        }

    }
}
