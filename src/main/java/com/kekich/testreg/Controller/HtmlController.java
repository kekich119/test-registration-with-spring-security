package com.kekich.testreg.Controller;

import com.kekich.testreg.interfaces.UserDetails;
import com.kekich.testreg.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HtmlController {

    @GetMapping("/main")
    public String showMainPage() {
        return "main";
    }

    @GetMapping("/main/register")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/main/login")
    public String showLoginPage() {
        return "login";
    }



    @GetMapping("/main/profile")
    public String getProfile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", userDetails.getLogin());
        return "profile";
    }
}
