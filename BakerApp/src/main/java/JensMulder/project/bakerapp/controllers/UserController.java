package JensMulder.project.bakerapp.controllers;

import JensMulder.project.bakerapp.controllers.base.ControllerBase;
import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import JensMulder.project.bakerapp.core.models.User;
import JensMulder.project.bakerapp.data.UserService;
import JensMulder.project.bakerapp.dto.user.RegisterRequest;
import JensMulder.project.bakerapp.dto.user.UpdateUserRequest;
import JensMulder.project.bakerapp.dto.user.UserDto;
import JensMulder.project.bakerapp.util.exceptions.ApiException;
import JensMulder.project.bakerapp.util.ApiResponse;
import JensMulder.project.bakerapp.util.auth.AuthenticationFacade;
import JensMulder.project.bakerapp.util.exceptions.UnauthorizedException;
import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/users")
public class UserController extends ControllerBase<User> {
    private final UserService service;

    public UserController(
            UserService service,
            Logger logger,
            ApiResponseFactory responseFactory,
            ModelMapper modelMapper,
            AuthenticationFacade authentication
    ) {
        super(service, logger, responseFactory, modelMapper, authentication);

        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<ApiResponse> getPage(@PathVariable Pageable pageable) {
        return super.<UserDto>getPage(pageable);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getOne(@PathVariable Long id) {
        return super.<UserDto>getOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody UpdateUserRequest item) {
        userAuthorizeCheck(id);

        return super.<UserDto, UpdateUserRequest>update(id, item);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> create(@RequestBody RegisterRequest item) {
        return super.<UserDto, RegisterRequest>create(item);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userAuthorizeCheck(id);

        return super.delete(id);
    }
}
