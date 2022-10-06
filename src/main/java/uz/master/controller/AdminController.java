package uz.master.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uz.master.DTOs.ArticleCreateDTO;
import uz.master.DTOs.AuthUser;
import uz.master.services.ArticleService;
import uz.master.services.AuthUserService;
import uz.master.session.SessionUser;

import java.util.Objects;

@Controller
public class AdminController {

    private final ArticleService articleService;
    private final AuthUserService authUserService;
    private final SessionUser sessionUser;


    public AdminController(ArticleService articleService, AuthUserService authUserService, SessionUser sessionUser) {
        this.articleService = articleService;
        this.authUserService = authUserService;
        this.sessionUser = sessionUser;
    }

    @GetMapping("/login")
    public String login(){
        return "Admin/login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect: /index";
    }

    @GetMapping("/panel")
    public String panel(){
        return "Admin/panel";
    }

    @PostMapping("/addArticle")
    public String createArticle(ArticleCreateDTO dto, Model model){
        String result = articleService.createArticle(dto);
        model.addAttribute("loginError", result);
        return "redirect:/panel";
    }

    @GetMapping("/cabinet")
    public String cabinet(Model model){
        AuthUser user = authUserService.getUser(sessionUser.getId());
        if(Objects.isNull(user)){
            return "404";
        }
        model.addAttribute("user",user);
        return "/staff/MyPage";
    }

    @GetMapping("/{name}")
    public String getStaff(@PathVariable String name, Model model){
        AuthUser user = authUserService.findUser(name);
        if(Objects.isNull(user)){
            return "404";
        }
        model.addAttribute("user", user);
        return "/staff/Staff";
    }



//    @PostMapping("/createNews")
//    public String createNews(NewsDTO dto){
//        String result = newsService.createNews(dto);
//        model.addAttribute("result", result);
//        return "redirect: /panel";
//    }

}
