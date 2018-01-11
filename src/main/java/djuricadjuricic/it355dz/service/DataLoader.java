package djuricadjuricic.it355dz.service;

import djuricadjuricic.it355dz.domain.Article;
import djuricadjuricic.it355dz.domain.ArticleType;
import djuricadjuricic.it355dz.domain.Role;
import djuricadjuricic.it355dz.domain.User;
import djuricadjuricic.it355dz.repository.ArticleRepository;
import djuricadjuricic.it355dz.repository.RoleRepository;
import djuricadjuricic.it355dz.repository.TypeRepository;
import djuricadjuricic.it355dz.repository.UserRepository;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLoader //used to load data without using a external file
{
    //declare all EntityRepositories that you will be writing into
    private ArticleRepository articleRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private TypeRepository typeRepository;
    
    //make a Autowired DataLoader like below ( //COMMENT IT OUT TO DISABLE THIS DATALOADER )
    @Autowired
    public DataLoader(ArticleRepository articleRepository, UserRepository userRepository, RoleRepository roleRepository, TypeRepository typeRepository)
    {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.typeRepository = typeRepository;
    }
    
    @PostConstruct //runs after Bean created
    private void loadData() //fill database with desired data
    {
        //adding articleTypes
        ArticleType at1 = new ArticleType("pending");
        ArticleType at2 = new ArticleType("allowed");
        ArticleType at3 = new ArticleType("approved");
        
        //adding roles
        Role r1 = new Role("ROLE_USER");
        Role r2 = new Role("ROLE_ADMIN");        
        
        Set<Role> userRole = new HashSet<Role>(); // set of roles with only the user role added
        userRole.add(r1);
        
        Set<Role> bothRoles = new HashSet<Role>(); // set of roles containing both roles
        bothRoles.add(r1);
        bothRoles.add(r2);

        //adding users
        User u1 = new User();
        u1.setUsername("djuro");
        u1.setPassword("123123");
        u1.setEmail("djurica.djuricic.2727@metropolitan.ac.rs");
        u1.setAbout("The founder of this site. He was once a fat fuck but he searched the depths of the internet to find his"+
                " salvation. Once he reached godly aesthetics, he made this site, in hopes to save all the fat cunts.");
        u1.setPremium(true);
        u1.setRoles(bothRoles);
        
        User u2 = new User();
        u2.setUsername("zyzz");
        u2.setPassword("123123");
        u2.setEmail("zy@zz.com");
        u2.setAbout("The aesthetic god himself. His transformation from a WoW geek to a diety has inspired milions.");
        u2.setPremium(false);
        u2.setRoles(userRole);
        
        Set<User> users = new HashSet<User>();
        users.add(u1);
        users.add(u2);
        
        Set<User> admins = new HashSet<User>();
        admins.add(u1);
        
        //adding articles
        Article a1 = new Article();
        a1.setTitle("First steps");
        a1.setSlug("first-steps");
        a1.setTeaser("The journey to aesthetics is not a short one, nor is it easy. This article covers the basics you"+
                "should master to get your dream body...");
        a1.setBody("The journey to aesthetics is not a short one, nor is it easy. This article covers the basics you"+
                "should master to get your dream body...<br> Aenean fermentum aliquet tellus. Maecenas in mauris ipsum. Nunc malesuada nisi eget eros egestas, "
                + "vitae facilisis felis tincidunt. Nunc eleifend mauris lacus, at maximus felis scelerisque sit amet. Curabitur ullamcorper est et turpis eleifend, at feugiat lorem consectetur."
                + " Morbi nec varius ante, in ultricies nibh. Donec dignissim vel nunc in pellentesque. Quisque mollis tellus a malesuada sagittis. Vivamus nec lacus id felis efficitur hendrerit non non lorem. In vehicula interdum leo et condimentum."
                + " Nulla posuere est lacus, vel convallis enim sodales ut. Ut feugiat tincidunt aliquam. Vestibulum finibus, arcu et pellentesque ultricies, ante metus ornare est, vitae condimentum lacus ante nec dolor. Maecenas ac sagittis nisi, nec convallis arcu. Aenean bibendum quis ligula vitae dignissim.");
        a1.setPosted(new Date());
        a1.setUser(u1);
        a1.setArticleType(at1);
        
        Article a2 = new Article();
        a2.setTitle("Dieting");
        a2.setSlug("dieting");
        a2.setTeaser("Dieting is the hardest this to lay grasp on as no ones body is the same"
                + "in this article, we're going to talk about the basics to getting that six-pack shining...");
        a2.setBody("Dieting is the hardest this to lay grasp on as no ones body is the same"
                + "in this article, we're going to talk about the basics to getting that six-pack shining..."
                + "<br>Aenean fermentum aliquet tellus. Maecenas in mauris ipsum. Nunc malesuada nisi eget eros egestas, "
                + "vitae facilisis felis tincidunt. Nunc eleifend mauris lacus, at maximus felis scelerisque sit amet. Curabitur ullamcorper est et turpis eleifend, at feugiat lorem consectetur."
                + " Morbi nec varius ante, in ultricies nibh. Donec dignissim vel nunc in pellentesque. Quisque mollis tellus a malesuada sagittis. Vivamus nec lacus id felis efficitur hendrerit non non lorem. In vehicula interdum leo et condimentum."
                + " Nulla posuere est lacus, vel convallis enim sodales ut. Ut feugiat tincidunt aliquam. Vestibulum finibus, arcu et pellentesque ultricies, ante metus ornare est, vitae condimentum lacus ante nec dolor. Maecenas ac sagittis nisi, nec convallis arcu. Aenean bibendum quis ligula vitae dignissim.");
        a2.setPosted(new Date());
        a2.setUser(u1);
        a1.setArticleType(at1);
        
        Article a3 = new Article();
        a3.setTitle("Muzzin");
        a3.setSlug("muzzin");
        a3.setTeaser("Muzzin is an art form. You've packed on some muscle, but plain on flexing isn't gonna cut it."
                + "In this article, we're going to teach you to present your body and appear casual yet stunning...");
        a3.setBody("Muzzin is an art form. You've packed on some muscle, but plain on flexing isn't gonna cut it."
                + "In this article, we're going to teach you to present your body and appear casual yet stunning..."
                + "<br>Aenean fermentum aliquet tellus. Maecenas in mauris ipsum. Nunc malesuada nisi eget eros egestas, "
                + "vitae facilisis felis tincidunt. Nunc eleifend mauris lacus, at maximus felis scelerisque sit amet. Curabitur ullamcorper est et turpis eleifend, at feugiat lorem consectetur."
                + " Morbi nec varius ante, in ultricies nibh. Donec dignissim vel nunc in pellentesque. Quisque mollis tellus a malesuada sagittis. Vivamus nec lacus id felis efficitur hendrerit non non lorem. In vehicula interdum leo et condimentum."
                + " Nulla posuere est lacus, vel convallis enim sodales ut. Ut feugiat tincidunt aliquam. Vestibulum finibus, arcu et pellentesque ultricies, ante metus ornare est, vitae condimentum lacus ante nec dolor. Maecenas ac sagittis nisi, nec convallis arcu. Aenean bibendum quis ligula vitae dignissim.");
        a3.setPosted(new Date());
        a3.setUser(u2);        
        a1.setArticleType(at1);
        
        typeRepository.save(at1);
        typeRepository.save(at2);
        typeRepository.save(at3);
        
        roleRepository.save(r1);
        roleRepository.save(r2);
        
        userRepository.save(u1);
        userRepository.save(u2);
        
        articleRepository.save(a1);
        articleRepository.save(a2);
        articleRepository.save(a3);
    }
}
