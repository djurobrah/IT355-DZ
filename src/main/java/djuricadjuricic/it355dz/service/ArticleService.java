package djuricadjuricic.it355dz.service;

import djuricadjuricic.it355dz.domain.Article;
import djuricadjuricic.it355dz.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService //used to load a single entity into db
{
    private ArticleRepository articleRepository;
    
    @Autowired
    public ArticleService(ArticleRepository articleRepository)
    {
        this.articleRepository = articleRepository;
    }

    // below define all methods that our EntityService will need

    public Article getBySlug(String slug)
    {
        return articleRepository.findBySlug(slug);
    }

    public Iterable<Article> findAllByOrderByPostedDesc()
    {
        return articleRepository.findArticlesByOrderByPostedDesc();
    }
    
    public Iterable<Article> findAllByUser_id(long userID)
    {
        return articleRepository.findAllByUser_id(userID);
    }
    
    public void delete(long id)
    {
        articleRepository.delete(id);
    }
    
    public void save(Article article)
    {
        articleRepository.save(article);
    }
    
}
