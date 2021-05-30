package JensMulder.project.bakerapp.core.contracts;

import JensMulder.project.bakerapp.core.models.User;

import java.util.Optional;

public interface IUserRepository extends IRepository<User> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
