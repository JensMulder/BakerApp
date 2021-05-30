package JensMulder.project.bakerapp.util.factories;

import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import JensMulder.project.bakerapp.core.contracts.IDbModel;
import JensMulder.project.bakerapp.util.*;
import JensMulder.project.bakerapp.util.exceptions.ApiException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.stream.Collectors;

public class ApiResponseFactory {
    public ResponseEntity<ApiResponse> createUnmappedResponse(Object item) {
        return new ResponseEntity<>(new ApiResponse(item, null), HttpStatus.OK);
    }

    public <TDto> ResponseEntity<ApiResponse> createResponse(ModelMapper mapper, Object item) {
        return new ResponseEntity<>(new ApiResponse(mapper.map(item, new TypeToken<TDto>() {}.getType()), null), HttpStatus.OK);
    }

    public <TDto> ResponseEntity<ApiResponse> createResponse(ModelMapper mapper, CrudResult<? extends IDbModel> result, HttpStatus statusCode) {
        statusCode = statusCode == null ? HttpStatus.OK : statusCode;

        return new ResponseEntity<>(new ApiResponse(mapper.map(result.getResult(), new TypeToken<TDto>() {}.getType()), null), statusCode);
    }

    public ResponseEntity<Object> createErrorResponse(ApiException exc) {
        return createErrorResponseEntity(new ApiError(exc));
    }

    public ResponseEntity<Object> createUnauthorizedResponse() {
        var error = new ApiError(HttpStatus.FORBIDDEN, ErrorConstants.ACCESS_DENIED_ERROR, ErrorConstants.ACCESS_DENIED_MSG);

        return createErrorResponseEntity(error);
    }

    public ResponseEntity<Object> createInternalServerErrorResponse() {
        var error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ErrorConstants.INTERNAL_SERVER_ERROR, ErrorConstants.INTERNAL_SERVER_ERROR_MSG);

        return createErrorResponseEntity(error);
    }

    public ResponseEntity<Object> createValidationErrorResponse(MethodArgumentNotValidException exc) {
        var validationErrors = exc.getBindingResult().getFieldErrors().stream().map(e -> new ValidationError(e.getField(), e.getDefaultMessage())).collect(Collectors.toList());

        var error = new ApiError(validationErrors);

        return createErrorResponseEntity(error);
    }

    private <T> ResponseEntity<ApiResponse> createSuccessResponseEntity(T result, HttpStatus status) {
        return new ResponseEntity<>(new ApiResponse(result, null), status);
    }

    private ResponseEntity<Object> createErrorResponseEntity(ApiError error) {
        return new ResponseEntity<>(new ApiResponse(null, error), HttpStatus.valueOf(error.getStatus()));
    }
}
