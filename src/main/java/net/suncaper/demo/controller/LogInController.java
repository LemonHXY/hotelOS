package net.suncaper.demo.controller;

import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/123")
public class LogInController {

    @Autowired
    private LogInService logInService;

    @GetMapping("/log")
    public String LogInPage() {
        return "/pages/user/list";
    }




    @GetMapping("/log2")
    public String SaveUserPage(Model model) {
        System.out.println("nihao");
        model.addAttribute("user", new User());
        return "/pages/user/login";
    }

    @PostMapping("/log2")
    public String SaveUser(User user) {
        logInService.saveUser(user);
        return "redirect:/123/log2";
    }





//    @RequestMapping("/search")
//    @ResponseBody
//    public List<User> findUsers(@RequestParam(value = "name", required = false) String name) {
//        return logInService.findUser(name);
//    }

    // 默认跳转页面
    // @RequestMapping不仅可以Get，也可以Post 6：35
    @RequestMapping
    public String userPage(Model model, @RequestParam(value = "name", required = false) String name) {
        // ? name= & age = 来传参
        List<User> users = logInService.findUser(name);
        // 通过model传导数据
        model.addAttribute("users", users);
        return "pages/user/login.html";
    }

}
