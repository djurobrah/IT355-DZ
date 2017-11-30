package djuricadjuricic.it355dz.repository;

import djuricadjuricic.it355dz.domain.User;
import org.springframework.data.repository.CrudRepository;

 
public interface UserRepository extends CrudRepository<User, Long> //parameters are Entity and Type of ID key
{   
    //define custom methods that are not in Crud Repository
    //use this: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
    
    public User findByUsername(String username);
}
