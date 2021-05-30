package JensMulder.project.bakerapp.data;

import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import JensMulder.project.bakerapp.core.contracts.IRoleRepository;
import JensMulder.project.bakerapp.core.contracts.IUserRepository;
import JensMulder.project.bakerapp.core.enums.BakerRoles;
import JensMulder.project.bakerapp.core.models.Role;
import JensMulder.project.bakerapp.core.models.User;
import JensMulder.project.bakerapp.dto.user.LoginRequest;
import JensMulder.project.bakerapp.util.exceptions.ApiException;
import JensMulder.project.bakerapp.util.CrudResult;
import JensMulder.project.bakerapp.util.ValidationError;
import JensMulder.project.bakerapp.util.auth.AuthenticationFacade;
import JensMulder.project.bakerapp.util.auth.JwtUtils;
import JensMulder.project.bakerapp.util.auth.LoginResult;
import JensMulder.project.bakerapp.util.auth.UserPrincipal;
import org.slf4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

@Service
public class AuthService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final IUserRepository userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final Logger logger;
    private final IRoleRepository roleRepo;

    public AuthService(
            BCryptPasswordEncoder passwordEncoder,
            IUserRepository userRepo,
            IRoleRepository roleRepo,
            AuthenticationManager authenticationManager,
            JwtUtils jwtUtils,
            Logger logger
    ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.logger = logger;
        this.roleRepo = roleRepo;
    }

    public CrudResult<User> register(User user) {
        logger.info(user.toString());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if(user.getRoles() != null) {
            var roles = new HashSet<Role>();

            roles.add(roleRepo.findByName(BakerRoles.USER)
                    .orElseThrow(() -> new RuntimeException(String.format(ErrorConstants.NOT_FOUND_ERROR_MSG, "rol", "naam", BakerRoles.USER))));

            user.setRoles(roles);
        }

        return save(user);
    }

    public User getByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException(String.format(ErrorConstants.NOT_FOUND_ERROR_MSG, "rol", "naam", BakerRoles.USER)));
    }

    public LoginResult login(LoginRequest loginRequest) {
        Authentication authentication;

        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword()));
        }
        catch(Exception exc) {
            throw new ApiException(HttpStatus.FORBIDDEN, ErrorConstants.BAD_CREDENTIALS_MSG);
        }

        AuthenticationFacade.setAuthentication(authentication);

        var jwt = "";

        try {
            jwt = jwtUtils.generateJwtToken(authentication);
        } catch(Exception exc) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Je moet een stoerdere key gebruiken (min. 512 bit, zie https://passwordsgenerator.net/sha512-hash-generator/)");
        }

        var principal = (UserPrincipal) authentication.getPrincipal();
        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new LoginResult(jwt, principal.getId(), principal.getUsername(), principal.getEmail(), roles);
    }

    private CrudResult<User> save(User item) throws ApiException {
        try {
            return new CrudResult<>(null, userRepo.save(item));
        } catch(DataIntegrityViolationException exc) {
            logger.info("ICU: " + exc.getClass().getCanonicalName());

            var errorList = new ArrayList<ValidationError>();

            errorList.add(new ValidationError("username", String.format(ErrorConstants.DUPLICATE_KEY_MSG, "gebruikersnaam", item.getUsername())));

            throw new ApiException(errorList);
        }
    }
}
