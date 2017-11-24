package djuricadjuricic.it355dz.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article 
{
    @Id
    @GeneratedValue
    private long id;
    
    private String title;
    
    @Column(columnDefinition = "TEXT") //when varchar(255) is not enough
    private String body;
    
    private Date posted;
    
    @ManyToOne //needed by Hibernate engine (we have many articles with one author)
    private Author author;
    
    private Article(){} //empty private constr. needed by JPA
    
    public Article(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
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

    public Author getAuthor()
    {
        return author;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }
    
    

    @Override
    public String toString()
    {
        return "Article{" + "title=" + title + '}';
    }

    
    
    
    
    
}
