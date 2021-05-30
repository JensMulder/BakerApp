package JensMulder.project.bakerapp.util;

import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiError {
    private final int status;
    private final String message;
    private final String description;
    private final List<ValidationError> validationErrors;

    public ApiError(HttpStatus status, String message, String description) {
        this.status = status.value();

        this.message = message == null ? ErrorConstants.INTERNAL_SERVER_ERROR : message;
        this.description = description == null ? ErrorConstants.INTERNAL_SERVER_ERROR_MSG : description;

        this.validationErrors = null;
    }

    public ApiError(ApiException exc) {
        this.status = exc.getStatus().value();
        this.message = exc.getMessage();
        this.description = exc.getReason();
        this.validationErrors = exc.getValidationErrors();
    }

    public ApiError(List<ValidationError> errors) {
        this.status = HttpStatus.BAD_REQUEST.value();
        this.description = ErrorConstants.VALIDATION_ERROR_MSG;
        this.message = ErrorConstants.VALIDATION_ERROR;
        this.validationErrors = errors;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }
}
