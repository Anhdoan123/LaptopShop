package vn.anhdoan.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.anhdoan.laptopshop.domain.User;

@Controller

public class UserController {

    @RequestMapping("/")
    public String home() {
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String createUser(Model modal) {
        modal.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model modal, @ModelAttribute("newUser") User user) {
        System.out.println(user);
        return "hello";
    }

}
