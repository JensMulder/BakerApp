package JensMulder.project.bakerapp.data;

import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import JensMulder.project.bakerapp.core.contracts.IUserRepository;
import JensMulder.project.bakerapp.util.ApiException;
import JensMulder.project.bakerapp.util.auth.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BakerUserDetailsService implements UserDetailsService {
    private final IUserRepository userRepo;

    public BakerUserDetailsService(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)  {
        var user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, String.format(ErrorConstants.NOT_FOUND_ERROR_MSG, "User", "username", username)));
        return UserPrincipal.build(user);
    }
}
