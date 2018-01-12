package djuricadjuricic.it355dz.controller;

import djuricadjuricic.it355dz.domain.User;
import djuricadjuricic.it355dz.service.ArticleService;
import djuricadjuricic.it355dz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@Controller if forwarding a html, @RestController if forwarding Strings etc.

@Controller
@RequestMapping("/users")
public class UserController 
{
    
    //Use a model to forward atributes used by this page
    //Model atributes should be provided by an Autowired service
    
    @Autowired
    UserService userService;
    
    @Autowired
    ArticleService articleService;
    
//    @Secured("ROLE_USER") //declare which user role can access this. For mult. roles use ({"dfds", "dfgdfg"}
    @RequestMapping("/")
    public String users(Model model)
    {        
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    
    @RequestMapping("/{username}")
    public String userPosts(@PathVariable(value = "username")String username, Model model)
    {
        //attributes that we forward to the mapped page
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        User currentUser = userService.findByUsername(currentUsername);
        model.addAttribute("currentUser", currentUser);
        User user = userService.findByUsername(username);
        model.addAttribute("articles", articleService.findAllByUser_id(user.getId()));
        model.addAttribute("user", user);
        return "articles";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
//    public @ResponseBody
    String grantPremium(@PathVariable(value = "id") long id, Model model, RedirectAttributes redirectAttributes)
    {
        User user = userService.findById(id);
        user.setPremium(true);
        userService.save(user);
        redirectAttributes.addFlashAttribute("premiumGranted", true);
        return "redirect:/users/";
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
