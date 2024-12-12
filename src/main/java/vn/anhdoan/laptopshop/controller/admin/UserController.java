package vn.anhdoan.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.jaxb.spi.XmlSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.anhdoan.laptopshop.domain.User;
import vn.anhdoan.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home() {
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model modal) {
        List<User> users = this.userService.getAllUsers();
        modal.addAttribute("listUser", users);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model modal) {
        modal.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(@ModelAttribute("newUser") User user) {
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/{id}")
    public String getUserDetail(@PathVariable long id, Model model) {
        Optional<User> user = this.userService.getUserById(id);
        model.addAttribute("userDetail", user.get());
        return "/admin/user/userDetail";
    }

    @RequestMapping(value = "/admin/user/update/{id}", method = RequestMethod.GET)
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        } else {
            model.addAttribute("error", "User not found!");
        }
        return "/admin/user/update";
    }

    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String UpdateUser(@ModelAttribute("user") User user) {
        User currentUser = this.userService.getUserById(user.getId()).get();

        if (currentUser != null) {
            currentUser.setEmail(user.getEmail());
            currentUser.setPhone(user.getPhone());
            currentUser.setFullName(user.getFullName());
            currentUser.setAddress(user.getAddress());
        }
        this.userService.handleSaveUser(currentUser);
        return "redirect:/admin/user";
    }

    @GetMapping(value = "/admin/user/delete/{id}")
    public String deleteUserPage(@PathVariable long id, Model model) {
        User user = new User();
        user.setId(id);
        model.addAttribute("user", user);
        return "/admin/user/delete";
    }

    @PostMapping(value = "/admin/user/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        this.userService.deleteUserById(user.getId());
        return "redirect:/admin/user";
    }

}
