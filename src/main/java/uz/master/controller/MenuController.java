package uz.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.master.domain.News;
import uz.master.services.ArticleService;
import uz.master.services.NewsService;

import java.util.List;

@Controller
public class MenuController {


    private final ArticleService articleService;
    private final NewsService newsService;

    public MenuController(ArticleService articleService, NewsService newsService) {
        this.articleService = articleService;
        this.newsService = newsService;
    }

    @GetMapping("/About")
    public String About(){
        return "About";

    }

    @GetMapping("/Articles")
    public String Articles(){
        return "Articles";

    }

    @GetMapping("/Commercialization")
    public String Commercialization(){
        return "Commercialization";

    }

    @GetMapping("/Contacts")
    public String Contacts(){
        return "Contacts";

    }

    @GetMapping("/Laboratories")
    public String Laboratories(){
        return "Laboratories";

    }

    @GetMapping("/News")
    public String News(){
        return "redirect:/News/0";

    }

    @GetMapping("/News/{page}")
    public String News(@PathVariable int page, Model model){
        List<News> content = newsService.getAllNews(page);
        model.addAttribute("news", content);
        return "News";

    }

    @GetMapping("/Projects")
    public String Projects(){
        return "Projects";

    }

    @GetMapping("/Regulatory-documents")
    public String RegulatoryDocuments(){
        return "Regulatory-documents";

    }

    @GetMapping("/Scientific-council")
    public String ScientificCouncil(){
        return "Scientific-council";

    }

    @GetMapping("/Seminars")
    public String Seminars(){
        return "redirect:/Seminars/0";

    }

    @GetMapping("/Seminars/{page}")
    public String Seminars(@PathVariable int page){
        List<News> content = newsService.getAllSeminars(page);
        return "Seminars";

    }


}
