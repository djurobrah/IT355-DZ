package djuricadjuricic.it355dz.controller;

import djuricadjuricic.it355dz.domain.User;
import djuricadjuricic.it355dz.service.ArticleService;
import djuricadjuricic.it355dz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller if forwarding a html, @RestController if forwarding Strings etc.

@Controller
@RequestMapping("/articles")
public class ArticleController 
{
    
    //Use a model to forward atributes used by this page
    //Model atributes should be provided by an Autowired service
    @Autowired
    ArticleService articleService;
    
    @Autowired
    UserService userService;
    
//    @Secured("ROLE_USER") //declare which user role can access this. For mult. roles use ({"dfds", "dfgdfg"}
    @RequestMapping("/")
    public String articles(Model model)
    {        
        model.addAttribute("articles", articleService.findAllByOrderByPostedDesc());
        return "articles";
    }
    
    @RequestMapping("/view/{slug}")
    public String view(@PathVariable(value = "slug")String slug, Model model)
    {
        //attributes that we forward to the mapped page
        model.addAttribute("article", articleService.getBySlug(slug));
        return "articleView";
    }
    
//    @RequestMapping("/{username}")
//    public String articlesByAuthor(@PathVariable(value = "username")String username, Model model)
//    {
//        //attributes that we forward to the mapped page
//        User user = userService.findByUsername(username);
//        Author author = authorService.findById(user.getId());
//        model.addAttribute("articlesByAuthor", articleService.g));
//        return "articleView";
//    }
    
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
