package djuricadjuricic.it355dz.service;

import djuricadjuricic.it355dz.domain.Role;
import djuricadjuricic.it355dz.domain.User;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails
{

    private User user;

    public UserDetailsImpl(User user)
    {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() //getter for all the users roles
    {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles)
        {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() //true if we don't have expiring accounts
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() //true if we don't lock accounts
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() //true if we don't expire credentials
    {
        return true;
    }

    @Override
    public boolean isEnabled() ////true if account is enabled
    {
        return true;
    }

}
