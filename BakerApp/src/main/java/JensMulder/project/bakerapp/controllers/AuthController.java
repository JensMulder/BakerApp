package JensMulder.project.bakerapp.controllers;

import JensMulder.project.bakerapp.core.models.User;
import JensMulder.project.bakerapp.data.AuthService;
import JensMulder.project.bakerapp.dto.user.RegisterRequest;
import JensMulder.project.bakerapp.dto.user.LoginRequest;
import JensMulder.project.bakerapp.dto.user.UserDto;
import JensMulder.project.bakerapp.util.ApiResponse;
import JensMulder.project.bakerapp.util.auth.AuthenticationFacade;
import JensMulder.project.bakerapp.util.exceptions.UnauthorizedException;
import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final ApiResponseFactory responseFactory;
    private final ModelMapper modelMapper;
    private final AuthenticationFacade authentication;

    public AuthController(AuthService authService, ApiResponseFactory responseFactory, ModelMapper modelMapper, AuthenticationFacade authentication) {
        this.authService = authService;
        this.responseFactory = responseFactory;
        this.modelMapper = modelMapper;
        this.authentication = authentication;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        return responseFactory.createUnmappedResponse(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody @Valid RegisterRequest signUpRequest) {
        return responseFactory.createUnmappedResponse(authService.register(modelMapper.map(signUpRequest, User.class)));
    }

    @GetMapping("user-info")
    public ResponseEntity<ApiResponse> getUserInfo() {
        if (authentication.getAuthentication() instanceof AnonymousAuthenticationToken)
            throw new UnauthorizedException();

        var userName = ((UserDetails) authentication.getAuthentication().getPrincipal()).getUsername();

        return responseFactory.<UserDto>createResponse(modelMapper, authService.getByUsername(userName));
    }
}
