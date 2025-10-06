package io.github.vfedoriv.javaoutput3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String showMenu(Model model) {
        return "menu";
    }

    @PostMapping("/menu/selection")
    public String handleMenuSelection(@RequestParam("selection") String selection, Model model) {
        switch (selection) {
            case "addSubject":
                return "redirect:/subject/add";
            case "addCourse":
                return "redirect:/course/add";
            case "viewStudents":
                return "redirect:/students/view";
            default:
                model.addAttribute("error", "Invalid selection");
                return "menu";
        }
    }
}