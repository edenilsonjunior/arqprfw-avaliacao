package edu.ifsp.inventorymanager.controllers;

import edu.ifsp.inventorymanager.models.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {


    @GetMapping
    public String register(Model model) {

        var user = new User();
        user.setId(1L);
        user.setName("Edenilson");
        user.setEmail("test@gmail.com");
        user.setPassword("123456");
        model.addAttribute("user", user);

        return "main";
    }
}