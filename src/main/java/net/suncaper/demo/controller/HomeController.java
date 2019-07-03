package net.suncaper.demo.controller;

import net.suncaper.demo.domain.MySearch;
import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

//主页控制器
@Controller
@RequestMapping({"index","/"})
public class HomeController {
    @Autowired
    private UserService userService;


    @GetMapping
    public String HomePage(Model model, HttpServletRequest request) {

        model.addAttribute("search",new MySearch());

        return "/index.html";
    }


    @PostMapping("/login")
    public String greetingSubmit(User user1,Model model) {
        User user=userService.findUserByUIid(user1.getuId());
        if(user!=null&&user.getuPassword()==user1.getuPassword())
            return "redirect:/index1";
        else{
//            model.addAttribute("user",new User() );
//            model.addAttribute("msg1","密码错误");
            return "/enter.html";}
    }

}
