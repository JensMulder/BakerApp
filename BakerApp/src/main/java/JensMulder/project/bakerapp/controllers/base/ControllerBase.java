package JensMulder.project.bakerapp.controllers.base;

import JensMulder.project.bakerapp.core.contracts.IDataService;
import JensMulder.project.bakerapp.core.contracts.IDbModel;
import JensMulder.project.bakerapp.core.enums.BakerRoles;
import JensMulder.project.bakerapp.util.exceptions.ApiException;
import JensMulder.project.bakerapp.util.ApiResponse;
import JensMulder.project.bakerapp.util.auth.AuthenticationFacade;
import JensMulder.project.bakerapp.util.auth.UserPrincipal;
import JensMulder.project.bakerapp.util.exceptions.UnauthorizedException;
import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;

public abstract class ControllerBase<T extends IDbModel> {
    private final IDataService<T> service;

    protected final AuthenticationFacade authentication;
    protected final ApiResponseFactory responseFactory;
    protected final ModelMapper modelMapper;
    protected final Logger logger;

    public ControllerBase(
            IDataService<T> service,
            Logger logger,
            ApiResponseFactory responseFactory,
            ModelMapper modelMapper,
            AuthenticationFacade authentication
    ) {
        this.service = service;
        this.logger = logger;
        this.responseFactory = responseFactory;
        this.modelMapper = modelMapper;
        this.authentication = authentication;
    }

    protected <TDto> ResponseEntity<ApiResponse> getPage(Pageable pageable) {
        return responseFactory.<TDto>createResponse(modelMapper, service.getPaged(pageable));
    }

    protected <TDto> ResponseEntity<ApiResponse> getOne(Long id) {
        return responseFactory.<TDto>createResponse(modelMapper, service.getById(id));
    }

    protected <TDtoOut, TDtoIn> ResponseEntity<ApiResponse> update(Long id, TDtoIn item) {
        return responseFactory.<TDtoOut>createResponse(
                modelMapper,
                service.update(id, modelMapper.map(item, new TypeToken<TDtoIn>() {}.getType())),
                null
        );
    }

    protected <TDtoOut, TDtoIn> ResponseEntity<ApiResponse> create(TDtoIn item) {
        return responseFactory.<TDtoOut>createResponse(
                modelMapper,
                service.create(modelMapper.map(item, new TypeToken<TDtoIn>() {}.getType())),
                HttpStatus.CREATED
        );
    }

    protected ResponseEntity<String> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    protected void userAuthorizeCheck(Long id) {
        var principal = (UserPrincipal) authentication.getAuthentication().getPrincipal();

        if (!principal.getId().equals(id)
                && principal.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .noneMatch(e -> e.equals(BakerRoles.ADMIN.name()))) {
            throw new UnauthorizedException();
        }
    }
}
