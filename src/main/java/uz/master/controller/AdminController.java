package uz.master.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect: /index";
    }

    @GetMapping("/panel")
    public String panel(){
        return "panel";
    }

    @PostMapping("/createArticle")
    public String createArticle(    ){
        return "redirect: /panel";
    }
}
