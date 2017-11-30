package djuricadjuricic.it355dz.service;

import djuricadjuricic.it355dz.domain.User;
import djuricadjuricic.it355dz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService//used to load a single entity into db
{
    private UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    // below define all methods that our EntityService will need

    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException
    {
        User user = findByUsername(string);
        if (user == null)
        {
            throw new UsernameNotFoundException(string);
        }
        else
        {
            return new UserDetailsImpl(user);
        }
    }
    
}
