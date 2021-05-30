package JensMulder.project.bakerapp.data;

import JensMulder.project.bakerapp.core.contracts.IRoleRepository;
import JensMulder.project.bakerapp.core.models.Role;
import JensMulder.project.bakerapp.data.base.ServiceBase;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class RoleService  extends ServiceBase<Role> {
    private final IRoleRepository roleRepo;

    public RoleService(IRoleRepository roleRepo, Logger logger) {
        super(roleRepo, logger);

        this.roleRepo = roleRepo;
    }
}
