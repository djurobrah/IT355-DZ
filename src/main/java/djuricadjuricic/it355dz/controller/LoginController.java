package djuricadjuricic.it355dz.controller;

import djuricadjuricic.it355dz.domain.Role;
import djuricadjuricic.it355dz.domain.User;
import djuricadjuricic.it355dz.service.RoleService;
import djuricadjuricic.it355dz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller if forwarding a html, @RestController if forwarding Strings etc.

@Controller
public class LoginController 
{
    
    //Use a model to forward atributes used by this page
    //Model atributes should be provided by an Autowired service
    @Autowired
    UserService userService;
    
    @Autowired
    RoleService roleService;

    
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
    
    @RequestMapping("/register/")
    public String register(Model model)
    {
        //attributes that we forward to the mapped page
        
        model.addAttribute("user", new User()); // forwarding a model of a empty entity, to be filled in form
        model.addAttribute("roles", roleService.getAllRoles());
        return "register";
    }
    
    @RequestMapping(value = "/register-success/", method = RequestMethod.POST)
    public String registerSuccess(User user, Model model)
    {
        //attributes that we forward to the mapped page
        //model.addAttribute("registerSuccess", true);
        user.getRoles().add(roleService.getById(1)); //hardcoded to 1 == author
        userService.save(user);
        return "login";
    }

}
