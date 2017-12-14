package djuricadjuricic.it355dz.controller;

import djuricadjuricic.it355dz.domain.Author;
import djuricadjuricic.it355dz.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller if forwarding a html, @RestController if forwarding Strings etc.
@RestController
@RequestMapping("/authors")
public class AuthorController
{

    //Use a model to forward atributes used by this page
    //Model atributes should be provided by an Autowired service
    @Autowired
    AuthorService authorService;

//    @RequestMapping("/")
//    public String authors(Model model)
//    {                
//        model.addAttribute("authors", authorService.getAllAuthors());
//        return "authors";
//    }
    
    @RequestMapping("/")
    public Iterable<Author>authors()
    {
        return authorService.getAllAuthors();
    }

    //Requesting mapping for all links that can be reached through this page (that don't have their controller)
//    @RequestMapping("/sta")
//    public String sta(Model model)
//    {
//        //attributes that we forward to the mapped page
//        
//        //model.addAttribute("prcatr", "bla");
//        return "sta";
//    }
}
