package vn.anhdoan.laptopshop.controller.client;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import vn.anhdoan.laptopshop.domain.Role;
import vn.anhdoan.laptopshop.domain.User;
import vn.anhdoan.laptopshop.domain.dto.RegisterDTO;
import vn.anhdoan.laptopshop.service.RoleService;
import vn.anhdoan.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;;

    public RegisterController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("newRegisterDTO", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String Register(@ModelAttribute("newRegisterDTO") @Valid RegisterDTO registerDTO,
            BindingResult newRegisterDTOBindingResult) {

        if (newRegisterDTOBindingResult.hasErrors()) {
            return "client/auth/register";
        }
        String hashPassWord = passwordEncoder.encode(registerDTO.getPassword());
        registerDTO.setPassword(hashPassWord);

        User user = this.userService.RegisterDTOToUser(registerDTO);

        Role role = this.roleService.getRoleByName("USER");

        user.setRole(role);

        this.userService.handleSaveUser(user);
        return "redirect:/login";
    }

}
