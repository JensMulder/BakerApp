package JensMulder.project.bakerapp.util;

import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class ApiException extends ResponseStatusException {
    private final List<ValidationError> validationErrors;

    public ApiException(HttpStatus status, String reason) {
        super(status, reason);

        this.validationErrors = null;
    }

    public ApiException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);

        this.validationErrors = null;
    }

    public ApiException(List<ValidationError> validationErrors) {
        super(HttpStatus.BAD_REQUEST, ErrorConstants.VALIDATION_ERROR_MSG);

        this.validationErrors = validationErrors;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    @Override
    public String getMessage() {
        if (validationErrors != null)
            return ErrorConstants.VALIDATION_ERROR;

        return ErrorConstants.INTERNAL_SERVER_ERROR;
    }
}
