package io.github.vfedoriv.javaoutput3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestParam String username, @RequestParam String password, Model model, RedirectAttributes redirectAttributes) {
        if (isValidUser(username, password)) {
            return "redirect:/mainMenu";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid username or password.");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    private boolean isValidUser(String username, String password) {
        // Implement user validation logic here
        return "user".equals(username) && "password".equals(password);
    }
}