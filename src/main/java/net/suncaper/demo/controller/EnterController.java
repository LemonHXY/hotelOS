package net.suncaper.demo.controller;

import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.io.UnsupportedEncodingException;

//登陆控制器
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
    public String greetingSubmit(User user1, Model model, HttpSession session,
                                 HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        // 新建cookie
        Cookie cookie1 = new Cookie("uId", user1.getuId().toString());

        User user = userService.findUserByUIid(user1.getuId());
        if (user != null && user.getuPassword().equals(user1.getuPassword())) {// 如果登陆成功
            cookie1.setMaxAge(60 * 60);//这里设置设置有效时间，单位的秒，我这里是一小时
            cookie1.setPath("/");//这里是之根目录下所有的目录都可以共享Cookie
            response.addCookie(cookie1);//添加Cookie
            return "redirect:/index";
        } else { // 如果登陆失败
            model.addAttribute("user", new User());
            model.addAttribute("msg1", "密码错误");
            return "/enter.html";
        }
    }
}