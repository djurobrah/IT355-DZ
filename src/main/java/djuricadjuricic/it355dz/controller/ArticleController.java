package djuricadjuricic.it355dz.controller;

import djuricadjuricic.it355dz.domain.Article;
import djuricadjuricic.it355dz.domain.User;
import djuricadjuricic.it355dz.service.ArticleService;
import djuricadjuricic.it355dz.service.TypeService;
import djuricadjuricic.it355dz.service.UserService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    TypeService typeService;
    
//    @Secured("ROLE_USER") //declare which user role can access this. For mult. roles use ({"dfds", "dfgdfg"}
    @RequestMapping("/")
    public String articles(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        User user = userService.findByUsername(currentUsername);
        model.addAttribute("currentUser", user);
        model.addAttribute("articles", articleService.findAllowednApproved());
        return "articles";
    }

    @RequestMapping("/{slug}")
    public String view(@PathVariable(value = "slug") String slug, Model model)
    {
        //attributes that we forward to the mapped page
        model.addAttribute("article", articleService.getBySlug(slug));
        return "articleView";
    }
    
    @RequestMapping("/pending")
    public String pending(Model model)
    {
        Iterable<Article> articles = articleService.findPending();
        int articlesSize = 0;
        for (Article article : articles)
        {
            articlesSize++;
        }
        model.addAttribute("articles", articles);
        model.addAttribute("articlesSize", articlesSize);
        return "pendingArticles";
    }
    
    @RequestMapping(value = "/pending/{id}", method = RequestMethod.PUT)
//    public @ResponseBody
    String allowPendingArticle(@PathVariable(value = "id") long id, Model model, RedirectAttributes redirectAttributes)
    {
        Article article = articleService.findById(id);
        article.setType(typeService.getById(2));
        articleService.save(article);
        redirectAttributes.addFlashAttribute("articleAllowed", true);
        return "redirect:/articles/pending/";
    }
    
    @RequestMapping(value = "/pending/{id}", method = RequestMethod.POST)
//    public @ResponseBody
    String approvePendingArticle(@PathVariable(value = "id") long id, Model model, RedirectAttributes redirectAttributes)
    {
        Article article = articleService.findById(id);
        article.setType(typeService.getById(3));
        articleService.save(article);
        redirectAttributes.addFlashAttribute("articleApproved", true);
        return "redirect:/articles/pending/";
    }
    
    @RequestMapping(value = "/pending/{id}", method = RequestMethod.DELETE)
//    public @ResponseBody
    String deletePendingArticle(@PathVariable(value = "id") long id, Model model, RedirectAttributes redirectAttributes)
    {
        //attributes that we forward to the mapped page
        //model.addAttribute("registerSuccess", true);
        articleService.delete(id);
        redirectAttributes.addFlashAttribute("articleDeleted", true);
        return "redirect:/articles/pending/";
    }

    @RequestMapping("/myArticles")
    public String myArticles(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        User user = userService.findByUsername(currentUsername);
        Iterable<Article> articles = articleService.findAllByUser_id(user.getId());
        int articlesSize = 0;
        for (Article article : articles)
        {
            articlesSize++;
        }
        model.addAttribute("articles", articles);
        model.addAttribute("articlesSize", articlesSize);
        model.addAttribute("user", user);
        return "myArticles";
    }

    @RequestMapping("/myArticles/create")
    public String articlesByAuthor(Model model)
    {
        //attributes that we forward to the mapped page

        model.addAttribute("article", new Article());
        return "articleForm";
    }

    
    @RequestMapping(value = "/myArticles/create-success", method = RequestMethod.POST)
    public String createSuccess(Article article, Model model, RedirectAttributes redirectAttributes)
    {
        //attributes that we forward to the mapped page
        if(article.getTitle().equals(""))
        {
            redirectAttributes.addFlashAttribute("articleAdded", true);
        }
        else
        {
           redirectAttributes.addFlashAttribute("articleEdited", true); 
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        User user = userService.findByUsername(currentUsername);
        article.setPosted(new Date());
        article.setUser(user);
        article.setType(typeService.getById(1));
        articleService.save(article);
        
        return "redirect:/articles/myArticles/";
    }

    
    @RequestMapping(value = "/myArticles/{id}", method = RequestMethod.GET)
    public String editArticle(@PathVariable(value = "id") long id, Model model)
    {
        //attributes that we forward to the mapped page
        model.addAttribute("article", articleService.findById(id));
        return "articleForm";
    }


    @RequestMapping(value = "/myArticles/{id}", method = RequestMethod.DELETE)
//    public @ResponseBody
    String deleteArticle(@PathVariable(value = "id") long id, Model model, RedirectAttributes redirectAttributes)
    {
        //attributes that we forward to the mapped page
        //model.addAttribute("registerSuccess", true);
        articleService.delete(id);
        redirectAttributes.addFlashAttribute("articleDeleted", true);
        return "redirect:/articles/myArticles/";
    }

}
