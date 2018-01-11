package djuricadjuricic.it355dz.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users") //declaring the name table will be created under (bad idea to call a table User)
public class User
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(columnDefinition = "TEXT") //when varchar(255) is not enough
    private String about;
    
    @Column(nullable = false)
    private boolean Premium;
    
    @OneToMany(mappedBy = "user") //needed by Hibernate engine (one user. has many art.) (mappedBy - who's the owner of this rel.)
    List<Article> articles;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) //creating a many to many relationship in the database
    @JoinTable(
            name = "users_roles",
            joinColumns =
            {
                @JoinColumn(name = "user_id")
            },
            inverseJoinColumns =
            {
                @JoinColumn(name = "role_id")
            }
    )
    private Set<Role> roles = new HashSet<Role>();

    public User()
    {
    } //empty constr. needed by JPA

    public int postCount()
    {
        return this.getArticles().size();
    }
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
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

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    public boolean isPremium()
    {
        return Premium;
    }

    public void setPremium(boolean Premium)
    {
        this.Premium = Premium;
    }


    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", about=" + about + ", Premium=" + Premium + ", articles=" + articles + ", roles=" + roles + '}';
    }

    
    

}   
