package djuricadjuricic.it355dz.controller;

import djuricadjuricic.it355dz.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller if forwarding a html, @RestController if forwarding Strings etc.

@Controller
public class LoginController 
{
    
    //Use a model to forward atributes used by this page
    //Model atributes should be provided by an Autowired service
//    @Autowired
//    AuthorService authorService;

    
    @RequestMapping("/login/")
    public String login(Model model)
    {                
        //model.addAttribute("authors", authorService.getAllAuthors());
        return "login";
    }
    
    
    //Requesting mapping for all links that can be reached through this page (that don't have their controller)
    
    @RequestMapping("/login-error/")
    public String loginError(Model model)
    {
        //attributes that we forward to the mapped page
        
        model.addAttribute("loginError", true);
        return "login";
    }
    
    @RequestMapping("/logout/")
    public String logout(Model model)
    {
        //attributes that we forward to the mapped page
        
        model.addAttribute("logout", true);
        return "login";
    }

}
