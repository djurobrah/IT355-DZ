package djuricadjuricic.it355dz.service;

import djuricadjuricic.it355dz.domain.ArticleType;
import djuricadjuricic.it355dz.domain.Role;
import djuricadjuricic.it355dz.repository.RoleRepository;
import djuricadjuricic.it355dz.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService //used to load a single entity into db
{
    private TypeRepository typeRepository;
    
    @Autowired
    public TypeService(TypeRepository typeRepository)
    {
        this.typeRepository = typeRepository;
    }
    
    // below define all methods that our EntityService needs

    public Iterable<ArticleType> getAllTypes()
    {
        return typeRepository.findAll();
    }
    
    public ArticleType getById(long id)
    {
        return typeRepository.findOne(id);
    }
    
    
}
