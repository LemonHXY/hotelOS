package net.suncaper.demo.controller;

import net.suncaper.demo.domain.User;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/enter.html","enter"})
public class Enter {
    @Autowired
    private UserService userService;

    //@GetMapping("/use")
    //public String useP( Model model) {
    //    return "/pages/user";
    //}

    @GetMapping
    public String userPage(Model model) {
        model.addAttribute("user",new User() );
        model.addAttribute("msg1","欢迎登陆");
        return "/enter.html";
    }


    @PostMapping("/login")
    public String greetingSubmit(User user1,Model model) {
        User user=userService.findUserByUIid(user1.getuId());
        if(user!=null&&user.getuPassword()==user1.getuPassword())
            return "redirect:/index";
        else{
            model.addAttribute("user",new User() );
            model.addAttribute("msg1","密码错误");
            return "/enter.html";}
    }
    /*@RequestMapping
    public String userPage(Model model,@RequestParam(value = "id", required = false) int id) {
        List<User> users = userService.findUser(id);
        model.addAttribute("user", users);
        return "pages/user/list.html";
    }*/
    /*
    @GetMapping("/add")
    public String addPage( Model model) {
        model.addAttribute("user", new Customer());
        return "/pages/user/add-user";
    }

    @GetMapping("update")
    public String editPage(int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "/pages/user/add-user";
    }

    @PostMapping("/add")
    public String saveUser(Customer customer) {
        Customer c=userService.findUserById(customer.getId());
        if(c.getId()>0)
        return "redirect:/user";
        userService.saveCustomer(customer);
        return "redirect:/user";
    }


    @GetMapping("/delete")
    public String deleteUserById(int id) {
        userService.deleteUserById(id);
        return "redirect:/user";
    }

    @RequestMapping
    public String userPage(Model model,@RequestParam(value = "name", required = false) String name) {
        List<Customer> users = userService.findUser(name);
        model.addAttribute("users", users);

        return "pages/user/list.html";
    }*/
}
