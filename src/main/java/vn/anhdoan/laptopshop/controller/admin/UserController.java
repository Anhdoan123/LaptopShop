package vn.anhdoan.laptopshop.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.anhdoan.laptopshop.domain.Role;
import vn.anhdoan.laptopshop.domain.User;
import vn.anhdoan.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.anhdoan.laptopshop.service.RoleService;
import vn.anhdoan.laptopshop.service.UploadService;

@Controller
public class UserController {
    private final RoleService roleService;
    private final UserService userService;
    private final UploadService uploadService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService, RoleService roleService,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
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
    public String createUserPage(@ModelAttribute("newUser") User user, @RequestParam("imgFile") MultipartFile file) {
        Role role = this.roleService.findRoleById(user.getRole().getId());
        user.setRole(role);
        String hashPassWord = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassWord);
        String avatar = "";
        if (!file.isEmpty()) {
            avatar = "";
        } else {
            avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        }
        user.setAvatar(avatar);
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
        Optional<User> user = this.userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        } else {
            model.addAttribute("error", "User not found!");
        }
        return "/admin/user/update";
    }

    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String UpdateUser(@ModelAttribute("user") User user, @RequestParam("imgFile") MultipartFile file) {
        User currentUser = this.userService.getUserById(user.getId()).get();
        Role role = this.roleService.findRoleById(user.getRole().getId());
        String avatar = "";
        if (file.isEmpty()) {
            avatar = currentUser.getAvatar();
        } else {
            avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        }

        if (currentUser != null) {
            currentUser.setEmail(user.getEmail());
            currentUser.setPhone(user.getPhone());
            currentUser.setFullName(user.getFullName());
            currentUser.setAddress(user.getAddress());
            currentUser.setRole(role);
            currentUser.setAvatar(avatar);
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
