package JensMulder.project.bakerapp.controllers;

import JensMulder.project.bakerapp.controllers.base.ControllerBase;
import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import JensMulder.project.bakerapp.core.models.User;
import JensMulder.project.bakerapp.data.UserService;
import JensMulder.project.bakerapp.dto.user.RegisterRequest;
import JensMulder.project.bakerapp.dto.user.UpdateUserDto;
import JensMulder.project.bakerapp.dto.user.UserDto;
import JensMulder.project.bakerapp.util.ApiException;
import JensMulder.project.bakerapp.util.ApiResponse;
import JensMulder.project.bakerapp.util.auth.AuthenticationFacade;
import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends ControllerBase<User> {
    private final UserService service;
    private final AuthenticationFacade authentication;

    public UserController(
            UserService service,
            Logger logger,
            ApiResponseFactory responseFactory,
            ModelMapper modelMapper,
            AuthenticationFacade authentication
    ) {
        super(service, logger, responseFactory, modelMapper);

        this.authentication = authentication;
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
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody UpdateUserDto item) {
        return super.<UserDto, UpdateUserDto>update(id, item);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> create(@RequestBody RegisterRequest item) {
        return super.<UserDto, RegisterRequest>create(item);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Long id) {
        return super.delete(id);
    }

    @GetMapping("user-info")
    public ResponseEntity<ApiResponse> getUserInfo() {
        if (authentication.getAuthentication() instanceof AnonymousAuthenticationToken)
            throw new ApiException(HttpStatus.UNAUTHORIZED, ErrorConstants.UNAUTHENTICATED_ERROR_MSG);

        var userName = ((UserDetails) authentication.getAuthentication().getPrincipal()).getUsername();

        return responseFactory.<UserDto>createResponse(modelMapper, service.getByUsername(userName));
    }
}
