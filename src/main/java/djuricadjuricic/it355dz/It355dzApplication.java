package djuricadjuricic.it355dz;

import djuricadjuricic.it355dz.repository.ArticleRepository;
import djuricadjuricic.it355dz.repository.AuthorRepository;
import djuricadjuricic.it355dz.service.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class It355dzApplication
{
    //DataLoader used to load data from class
    @Autowired
    DataLoader dl; 
    
// !!!!!!!!!!!!!!!!!!!!!!!! Used to load data from data-h2.sql
//    @Autowired
//    ArticleRepository articleRepository;
//    
//    @Autowired
//    AuthorRepository authorRepository;
    
    public static void main(String[] args)
    {
        SpringApplication.run(It355dzApplication.class, args);
    }
}
