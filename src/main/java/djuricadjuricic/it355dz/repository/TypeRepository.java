package djuricadjuricic.it355dz.repository;

import djuricadjuricic.it355dz.domain.Type;
import org.springframework.data.repository.CrudRepository;

 public interface TypeRepository extends CrudRepository<Type, Long> //parameters are Entity and Type of ID key
{   
    //define custom methods that are not in Crud Repository
    //use this: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
    
}
