package JensMulder.project.bakerapp.middleware.exceptionHandlers;

import JensMulder.project.bakerapp.util.ApiError;
import JensMulder.project.bakerapp.util.ApiException;
import JensMulder.project.bakerapp.util.ApiResponse;
import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BakerExceptionHandler extends ResponseEntityExceptionHandler
{
    private final ApiResponseFactory responseFactory;

    public BakerExceptionHandler(ApiResponseFactory responseFactory) {
        this.responseFactory = responseFactory;
    }

    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<Object> apiExceptionHandler(ApiException exc, WebRequest request) {
        return responseFactory.createErrorResponse(exc);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Object> runtimeExceptionHandler(RuntimeException exc, WebRequest request) {
        return responseFactory.createInternalServerErrorResponse();
    }

    @Override
    protected final @NotNull ResponseEntity<Object> handleMethodArgumentNotValid(
            @NotNull MethodArgumentNotValidException ex,
            @NotNull HttpHeaders headers,
            @NotNull HttpStatus status,
            @NotNull WebRequest request
    ) {

        return responseFactory.createValidationErrorResponse(ex);
    }
}
