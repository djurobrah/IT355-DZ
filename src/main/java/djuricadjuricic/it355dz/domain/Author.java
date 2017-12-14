package djuricadjuricic.it355dz.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Author
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    String name;

    @Column(columnDefinition = "TEXT") //when varchar(255) is not enough
    String about;

    @OneToMany(mappedBy = "author") //needed by Hibernate engine (one auth. has many art.) (mappedBy - who's the owner of this rel.)
    List<Article> articles;

    @OneToOne(fetch = FetchType.LAZY) // should have optional = false
    @JoinColumn(name = "user") //unique = true) // might not be correct - the unique
    private User user;

    private Author()
    {
    } //empty private constr. needed by JPA

    public Author(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAbout()
    {
        return about;
    }

    public void setAbout(String about)
    {
        this.about = about;
    }

    public List<Article> getArticles()
    {
        return articles;
    }

    public void setArticles(List<Article> articles)
    {
        this.articles = articles;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Author{" + "name=" + name + '}';
    }

}
