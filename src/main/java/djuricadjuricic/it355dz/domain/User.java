package djuricadjuricic.it355dz.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //creating a many to many relationship in the database
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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Author author;

    public User()
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

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
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
        return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
    }

}
