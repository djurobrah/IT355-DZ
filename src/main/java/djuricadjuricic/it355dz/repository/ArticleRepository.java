package djuricadjuricic.it355dz.repository;

import djuricadjuricic.it355dz.domain.Article;
import org.springframework.data.repository.CrudRepository;

 
public interface ArticleRepository extends CrudRepository<Article, Long> //parameters are Entity and Type of ID key
{
    
}
