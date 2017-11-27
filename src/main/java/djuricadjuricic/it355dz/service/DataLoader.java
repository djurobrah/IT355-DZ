package djuricadjuricic.it355dz.service;

import djuricadjuricic.it355dz.domain.Article;
import djuricadjuricic.it355dz.domain.Author;
import djuricadjuricic.it355dz.repository.ArticleRepository;
import djuricadjuricic.it355dz.repository.AuthorRepository;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLoader //used to load data without using a external file
{
    //declare all EntityRepositories that you will be writing into
    private ArticleRepository articleRepository;
    private AuthorRepository authorRepository;
    
    //make a Autowired DataLoader like below ( //COMMENT IT OUT TO DISABLE THIS DATALOADER )
    @Autowired
    public DataLoader(ArticleRepository articleRepository, AuthorRepository authorRepository)
    {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }
    
    @PostConstruct //runs after Bean created
    private void loadData() //fill database with desired data
    {
        Author author1 = new Author("djuro");
        author1.setAbout("DSGFSHFHSDHFSHODFOSHDFHSODHFSHODFHOSDF");
        authorRepository.save(author1);
        
        Author author2 = new Author("djuro2");
        author2.setAbout("znj");
        authorRepository.save(author2);
        
        Article article1 = new Article("articleTitleee1");
        article1.setSlug("article1");
        article1.setTeaser("dgsdssfkihdsdfhsdhfhdsolfsldflslsdhfs");
        article1.setBody("dgsdssfkihdsdfhsdhfhdsolfsldflslsdhfsdgsdssfkihdsdfhsdhfhdsolfsldflslsdhfsdgsdssfkihdsdfhsdhfhdsolfsldflslsdhfs");
        article1.setPosted(new Date());
        article1.setAuthor(author1);
        articleRepository.save(article1);
        
        Article article2 = new Article("articleTitleee2");
        article2.setSlug("article2");
        article2.setTeaser("abcabcabcabc");
        article2.setBody("abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc");
        article2.setPosted(new Date());
        article2.setAuthor(author2);
        articleRepository.save(article2);
    }
}
