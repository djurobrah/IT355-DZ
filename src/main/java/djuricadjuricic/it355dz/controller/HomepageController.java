package djuricadjuricic.it355dz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller if forwarding views, @RestController if forwarding Strings etc.

@Controller
public class HomepageController 
{
    //Forwarding attributes to this page if needed
    
    @RequestMapping("/")
    public String home(Model model)
    {
        //attributes that we forward to the mapped page
        //model.addAttribute("prcatr", "bla");
        return "index";
    }
    
    @RequestMapping("/about/")
    public String about(Model model)
    {
        //attributes that we forward to the mapped page
        //model.addAttribute("prcatr", "bla");
        return "about";
    }
    
}