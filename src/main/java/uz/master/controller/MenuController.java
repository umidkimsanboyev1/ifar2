package uz.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.master.DTOs.SearchDTO;
import uz.master.DTOs.ArticleThymeleafDTO;
import uz.master.domain.News;
import uz.master.services.ArticleService;
import uz.master.services.NewsService;

import java.util.List;

@Controller
public class MenuController {


    private final NewsService newsService;
    private final ArticleService articleService;

    public MenuController(NewsService newsService, ArticleService articleService) {
        this.newsService = newsService;
        this.articleService = articleService;
    }

    @GetMapping("/About")
    public String About() {
        return "About";

    }

    @GetMapping("/Articles")
    public String Articles() {
        return "redirect:/Articles/true/0";

    }

    @GetMapping("/Articles/{byDate}")
    public String Articles(@PathVariable boolean byDate) {
        return "redirect:/Articles/" + byDate + "/0";

    }

    @GetMapping("/Articles/{byDate}/{page}")
    public String Articles(@PathVariable int page, Model model, @PathVariable boolean byDate) {
        List<ArticleThymeleafDTO> content = articleService.getAllArticles(page, byDate);
        model.addAttribute("articles", content);
        return "Articles";

    }

    @GetMapping("/Articles/search")
    public String Articles(SearchDTO dto, Model model) {
        List<ArticleThymeleafDTO> content = articleService.search(dto.getText());
        model.addAttribute("articles", content);
        return "Articles";
    }

    @GetMapping("/Commercialization")
    public String Commercialization() {
        return "Commercialization";

    }

    @GetMapping("/Contacts")
    public String Contacts() {
        return "Contacts";

    }

    @GetMapping("/Laboratories")
    public String Laboratories() {
        return "Laboratories";

    }

    @GetMapping("/News")
    public String News() {
        return "redirect:/News/true/0";

    }

    @GetMapping("/News/{byDate}")
    public String News(@PathVariable boolean byDate) {
        return "redirect:/News/" + byDate + "/0";

    }

    @GetMapping("/News/{byDate}/{page}")
    public String News(@PathVariable int page, Model model, @PathVariable boolean byDate) {
        List<News> content = newsService.getAllNews(page, byDate);
        model.addAttribute("content", content);
        return "News";

    }

    @GetMapping("/News/search")
    public String News(SearchDTO dto, Model model) {
        List<News> content = newsService.newsSearch(dto.getText());
        model.addAttribute("articles", content);
        return "News";
    }

    @GetMapping("/Seminars")
    public String Seminars() {
        return "redirect:/Seminars/true/0";

    }

    @GetMapping("/Seminars/{byDate}")
    public String Seminars(@PathVariable boolean byDate) {
        return "redirect:/Seminars/" + byDate + "/0";

    }

    @GetMapping("/Seminars/{byDate}/{page}")
    public String Seminars(@PathVariable int page, Model model, @PathVariable boolean byDate) {
        List<News> content = newsService.getAllSeminars(page, byDate);
        model.addAttribute("content", content);
        return "Seminars";

    }

    @GetMapping("/Seminars/search")
    public String Seminars(SearchDTO dto, Model model) {
        List<News> content = newsService.seminarSearch(dto.getText());
        model.addAttribute("articles", content);
        return "Seminars";
    }

    @GetMapping("/Projects")
    public String Projects() {
        return "Projects";

    }

    @GetMapping("/Regulatory-documents")
    public String RegulatoryDocuments() {
        return "Regulatory-documents";

    }

    @GetMapping("/Scientific-council")
    public String ScientificCouncil() {
        return "Scientific-council";

    }



}
