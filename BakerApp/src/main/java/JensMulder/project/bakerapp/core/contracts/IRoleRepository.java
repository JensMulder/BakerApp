package JensMulder.project.bakerapp.core.contracts;

import JensMulder.project.bakerapp.core.enums.BakerRoles;
import JensMulder.project.bakerapp.core.models.Role;

import java.util.Optional;

public interface IRoleRepository extends IRepository<Role> {
    Optional<Role> findByName(BakerRoles name);
}
