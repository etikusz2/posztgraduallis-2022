package edu.bbte.bibliospring.backend.web;

import edu.bbte.bibliospring.backend.model.User;
import edu.bbte.bibliospring.backend.service.LoginService;
import edu.bbte.bibliospring.backend.service.ServiceException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, HttpSession session) {
        if (loginService.login(user)) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/books";
        } else {
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("newUser", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("newUser") User newUser, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        try {
            loginService.register(newUser);
            return "redirect:/login";
        } catch (ServiceException e) {
            return "register";
        }
    }
}

