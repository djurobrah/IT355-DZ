package djuricadjuricic.it355dz.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Article
{

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(columnDefinition = "TEXT") //when varchar(255) is not enough
    private String teaser;

    @Column(columnDefinition = "TEXT") //when varchar(255) is not enough
    private String body;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP") //timestamp is more precise
    private Date posted;

    @ManyToOne //needed by Hibernate engine (we have many articles with one author)
    private User user;

    @ManyToOne //needed by Hibernate engine (we have many articles with one author)
    private ArticleType articleType;
    
    public Article()
    {
    } //empty constr. needed by JPA

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getSlug()
    {
        return slug;
    }

    public void setSlug(String slug)
    {
        this.slug = slug;
    }

    public String getTeaser()
    {
        return teaser;
    }

    public void setTeaser(String teaser)
    {
        this.teaser = teaser;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public Date getPosted()
    {
        return posted;
    }

    public void setPosted(Date posted)
    {
        this.posted = posted;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public ArticleType getArticleType()
    {
        return articleType;
    }

    public void setArticleType(ArticleType articleType)
    {
        this.articleType = articleType;
    }

    @Override
    public String toString()
    {
        return "Article{" + "id=" + id + ", title=" + title + ", slug=" + slug + ", teaser=" + teaser + ", body=" + body + ", posted=" + posted + ", user=" + user + ", articleType=" + articleType + '}';
    }
    
    

}
