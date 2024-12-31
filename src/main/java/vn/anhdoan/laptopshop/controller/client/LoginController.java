package vn.anhdoan.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.anhdoan.laptopshop.domain.dto.RegisterDTO;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage() {
        // model.addAttribute("newRegisterDTO", new RegisterDTO());
        return "client/auth/login";
    }

}
