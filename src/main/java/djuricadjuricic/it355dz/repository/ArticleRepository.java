package djuricadjuricic.it355dz.repository;

import djuricadjuricic.it355dz.domain.Article;
import org.springframework.data.repository.CrudRepository;

 
//inside define custom methods that are not in Crud Repository
//use this: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
public interface ArticleRepository extends CrudRepository<Article, Long> //parameters are Entity and Type of ID key
{
    public Article findBySlug(String slug);

    public Iterable<Article> findAllByOrderByPostedDesc();
}
