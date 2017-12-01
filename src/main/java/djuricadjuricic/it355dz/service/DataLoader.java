package djuricadjuricic.it355dz.service;

import djuricadjuricic.it355dz.domain.Article;
import djuricadjuricic.it355dz.domain.Author;
import djuricadjuricic.it355dz.domain.Role;
import djuricadjuricic.it355dz.domain.User;
import djuricadjuricic.it355dz.repository.ArticleRepository;
import djuricadjuricic.it355dz.repository.AuthorRepository;
import djuricadjuricic.it355dz.repository.RoleRepository;
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
    private AuthorRepository authorRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    
    //make a Autowired DataLoader like below ( //COMMENT IT OUT TO DISABLE THIS DATALOADER )
    @Autowired
    public DataLoader(ArticleRepository articleRepository, AuthorRepository authorRepository, UserRepository userRepository, RoleRepository roleRepository)
    {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    
    @PostConstruct //runs after Bean created
    private void loadData() //fill database with desired data
    {
        Author author1 = new Author("Djurica Djuricic");
        author1.setAbout("The founder of this site. He was once a fat fuck but he searched the depths of the internet to find his"+
                " salvation. Once he reached godly aesthetics, he made this site, in hopes to save all the fat cunts.");
        authorRepository.save(author1);
        
        Author author2 = new Author("Zyzz");
        author2.setAbout("The aesthetic god himself. His transformation from a WoW geek to a diety has inspired milions.");
        authorRepository.save(author2);
        
        Article article1 = new Article("First steps");
        article1.setSlug("first-steps");
        article1.setTeaser("The journey to aesthetics is not a short one, nor is it easy. This article covers the basics you"+
                "should master to get your dream body...");
        article1.setBody("The journey to aesthetics is not a short one, nor is it easy. This article covers the basics you"+
                "should master to get your dream body...<br> Aenean fermentum aliquet tellus. Maecenas in mauris ipsum. Nunc malesuada nisi eget eros egestas, "
                + "vitae facilisis felis tincidunt. Nunc eleifend mauris lacus, at maximus felis scelerisque sit amet. Curabitur ullamcorper est et turpis eleifend, at feugiat lorem consectetur."
                + " Morbi nec varius ante, in ultricies nibh. Donec dignissim vel nunc in pellentesque. Quisque mollis tellus a malesuada sagittis. Vivamus nec lacus id felis efficitur hendrerit non non lorem. In vehicula interdum leo et condimentum."
                + " Nulla posuere est lacus, vel convallis enim sodales ut. Ut feugiat tincidunt aliquam. Vestibulum finibus, arcu et pellentesque ultricies, ante metus ornare est, vitae condimentum lacus ante nec dolor. Maecenas ac sagittis nisi, nec convallis arcu. Aenean bibendum quis ligula vitae dignissim.");
        article1.setPosted(new Date());
        article1.setAuthor(author1);
        articleRepository.save(article1);
        
        Article article2 = new Article("Dieting");
        article2.setSlug("dieting");
        article2.setTeaser("Dieting is the hardest this to lay grasp on as no ones body is the same"
                + "in this article, we're going to talk about the basics to getting that six-pack shining...");
        article2.setBody("Dieting is the hardest this to lay grasp on as no ones body is the same"
                + "in this article, we're going to talk about the basics to getting that six-pack shining..."
                + "<br>Aenean fermentum aliquet tellus. Maecenas in mauris ipsum. Nunc malesuada nisi eget eros egestas, "
                + "vitae facilisis felis tincidunt. Nunc eleifend mauris lacus, at maximus felis scelerisque sit amet. Curabitur ullamcorper est et turpis eleifend, at feugiat lorem consectetur."
                + " Morbi nec varius ante, in ultricies nibh. Donec dignissim vel nunc in pellentesque. Quisque mollis tellus a malesuada sagittis. Vivamus nec lacus id felis efficitur hendrerit non non lorem. In vehicula interdum leo et condimentum."
                + " Nulla posuere est lacus, vel convallis enim sodales ut. Ut feugiat tincidunt aliquam. Vestibulum finibus, arcu et pellentesque ultricies, ante metus ornare est, vitae condimentum lacus ante nec dolor. Maecenas ac sagittis nisi, nec convallis arcu. Aenean bibendum quis ligula vitae dignissim.");
        article2.setPosted(new Date());
        article2.setAuthor(author2);
        articleRepository.save(article2);
        
        User u1 = new User("Djurica Djuricic");
        u1.setPassword("123123");
        u1.setEmail("djurica.djuricic.2727@metropolitan.ac.rs");
        
        Role r1 = new Role("ROLE_AUTHOR");
        
        Set<User> users = new HashSet<User>();
        users.add(u1);
        Set<Role> roles = new HashSet<Role>();
        roles.add(r1);
        u1.setRoles(roles);
        r1.setUsers(users);
        
        userRepository.save(u1);
        roleRepository.save(r1);
    }
}
