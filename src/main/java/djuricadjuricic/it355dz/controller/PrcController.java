package djuricadjuricic.it355dz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller if forwarding a html, @RestController if forwarding Strings etc.

@Controller
@RequestMapping("/prc")
public class PrcController 
{
    
    //Forwarding attributes to this page if needed
    
    @RequestMapping("/")
    public String prc(Model model)
    {        
        //getting attributes that THIS page uses
        
        //model.addAttribute("atribut", print());
        return "prc";
    }
    
    
    //Requesting mapping for all links that can be reached through this page (that don't have their controller)
    
    @RequestMapping("/sta")
    public String sta(Model model)
    {
        //attributes that we forward to the mapped page
        
        //model.addAttribute("prcatr", "bla");
        return "sta";
    }
    
    @RequestMapping("/bla")
    public String bla(Model model)
    {
        //attributes that we forward to the mapped page
        
        model.addAttribute("bla", "1234bla");
        return "bla";
    }

}
