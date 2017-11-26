package djuricadjuricic.it355dz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class It355dzApplication
{
    
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!DataLoader used to load data from a single class
//    @Autowired
//    DataLoader dl; 
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Used to load data from data-h2.sql
//    @Autowired
//    ArticleRepository articleRepository;
//    
//    @Autowired
//    AuthorRepository authorRepository;
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    
    public static void main(String[] args)
    {
        SpringApplication.run(It355dzApplication.class, args);
    }

}
