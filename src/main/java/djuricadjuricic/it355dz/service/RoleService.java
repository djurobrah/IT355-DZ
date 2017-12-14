package djuricadjuricic.it355dz.service;

import djuricadjuricic.it355dz.domain.Role;
import djuricadjuricic.it355dz.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService //used to load a single entity into db
{
    private RoleRepository roleRepository;
    
    @Autowired
    public RoleService(RoleRepository roleRepository)
    {
        this.roleRepository = roleRepository;
    }
    
    // below define all methods that our EntityService needs

    public Iterable<Role> getAllRoles()
    {
        return roleRepository.findAll();
    }
    
    public Role getById(long id)
    {
        return roleRepository.findOne(id);
    }
    
    
}
