package JensMulder.project.bakerapp.data;

import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import JensMulder.project.bakerapp.core.contracts.IUserRepository;
import JensMulder.project.bakerapp.core.models.User;
import JensMulder.project.bakerapp.util.exceptions.ApiException;
import JensMulder.project.bakerapp.util.CrudResult;
import JensMulder.project.bakerapp.data.base.ServiceBase;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceBase<User> {
    private final IUserRepository repo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(IUserRepository repo, Logger logger, BCryptPasswordEncoder passwordEncoder) {
        super(repo, logger);

        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public User getByUsername(String username) {
        return repo.findByUsername(username)
                .orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, String.format(ErrorConstants.NOT_FOUND_ERROR_MSG, "User", "username", username)));
    }

    @Override
    public CrudResult<User> create(User item) {
        item.setPassword(passwordEncoder.encode(item.getPassword()));

        return super.create(item);
    }
}