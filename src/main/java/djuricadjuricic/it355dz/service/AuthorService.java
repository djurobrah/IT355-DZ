package djuricadjuricic.it355dz.service;

import djuricadjuricic.it355dz.domain.Author;
import djuricadjuricic.it355dz.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService //used to load a single entity into db
{
    private AuthorRepository authorRepository;
    
    @Autowired
    public AuthorService(AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }
    
    // below define all methods that our EntityService needs
    
    public Iterable<Author> getAllAuthors()
    {
        return authorRepository.findAll();
    }
}
