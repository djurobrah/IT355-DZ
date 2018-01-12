package djuricadjuricic.it355dz.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type
{

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    
    @OneToMany(mappedBy = "type") //needed by Hibernate engine (one type. has multiple art.) (mappedBy - who's the owner of this rel.)
    List<Article> articles;

    public Type(String type)
    {
        this.type = type;
    }

    public Type()
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
