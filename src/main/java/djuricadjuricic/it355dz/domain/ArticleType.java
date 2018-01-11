package djuricadjuricic.it355dz.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class ArticleType
{

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    
    @OneToMany(mappedBy = "articleType") //needed by Hibernate engine (one type. has multiple art.) (mappedBy - who's the owner of this rel.)
    List<Article> articles;

    public ArticleType(String role)
    {
        this.type = role;
    }

    public ArticleType()
    {
    } //empty constr. needed by JPA

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public List<Article> getArticles()
    {
        return articles;
    }

    public void setArticles(List<Article> articles)
    {
        this.articles = articles;
    }

    @Override
    public String toString()
    {
        return "ArticleType{" + "id=" + id + ", type=" + type + ", articles=" + articles + '}';
    }

    
   
}
