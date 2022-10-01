package uz.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

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
        return "Seminars";

    }


}
