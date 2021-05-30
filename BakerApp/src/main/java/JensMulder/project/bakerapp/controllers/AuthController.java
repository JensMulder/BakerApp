package JensMulder.project.bakerapp.controllers;

import JensMulder.project.bakerapp.core.models.User;
import JensMulder.project.bakerapp.data.AuthService;
import JensMulder.project.bakerapp.dto.user.RegisterRequest;
import JensMulder.project.bakerapp.dto.user.LoginRequest;
import JensMulder.project.bakerapp.util.ApiResponse;
import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final ApiResponseFactory responseFactory;
    private final ModelMapper modelMapper;

    public AuthController(AuthService authService, ApiResponseFactory responseFactory, ModelMapper modelMapper) {
        this.authService = authService;
        this.responseFactory = responseFactory;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        return responseFactory.createUnmappedResponse(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody @Valid RegisterRequest signUpRequest) {
        return responseFactory.createUnmappedResponse(authService.register(modelMapper.map(signUpRequest, User.class)));
    }
}
