package net.suncaper.demo.controller;

import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.*;

//登陆控制器
@Controller
@RequestMapping({"enter"})
public class EnterController {
    @Autowired
    private UserService userService;


    @GetMapping
    public String userPage(Model model ,HttpServletRequest request) {
        Cookie[] cookies=request.getCookies();
        if ((cookies!=null)){//判断Cookie是否为空
            for (Cookie cookie : cookies){//遍历Cookie判断有没有对应的name
                if (cookie.getValue().equals("uId")){//有就直接return true
                    return "redirect:/index";
                }
            }
        }
        model.addAttribute("user", new User());
        model.addAttribute("msg1", "欢迎登陆");
        return "/enter.html";
    }

    //接受登录信息并进行处理
    @PostMapping("/login")
    public String greetingSubmit(User user1, Model model,HttpServletResponse response) {
        User user = userService.findUserByUIid(user1.getuId());
        if (user != null && user.getuPassword().equals(user1.getuPassword())) {
            String userId=user1.getuId().toString();
            Cookie cookie = new Cookie("uId", userId);
            Cookie cookie1 = new Cookie("uName", user.getuName());

            cookie.setPath("/");
            cookie1.setPath("/");

            response.addCookie(cookie);
            response.addCookie(cookie1);

            return "redirect:/index";
        }
        else {
            model.addAttribute("user",new User());
            model.addAttribute("msg1", "密码错误");
            return "/enter.html";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie :cookies){//遍历所有Cookie
            if(cookie!=null){//找到对应的cookie
                cookie.setMaxAge(0);//Cookie并不能根本意义上删除，只需要这样设置为0即可
                cookie.setPath("/");//很关键，设置成跟写入cookies一样的，全路径共享Cookie
                response.addCookie(cookie);//重新响应
            }
        }
        return "redirect:/index";
    }

}