package uz.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping({"/", "/index", "/Home-page"})
    public String getIndex() {
        return "index";
    }

}
