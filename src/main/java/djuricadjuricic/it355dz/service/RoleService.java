package djuricadjuricic.it355dz.service;

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
    

}
