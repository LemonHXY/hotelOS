package net.suncaper.demo.controller;

import net.suncaper.demo.domain.Customer;
import net.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

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
    }
}
