package djuricadjuricic.it355dz.repository;

import djuricadjuricic.it355dz.domain.Author;
import org.springframework.data.repository.CrudRepository;

 
public interface AuthorRepository extends CrudRepository<Author, Long> //parameters are Entity and Type of ID key
{
    
}
