package JensMulder.project.bakerapp.core.constants;

public final class ErrorConstants {
    // Since static classes don't exist in Java...
    private ErrorConstants() {}

    // Error names
    public static final String VALIDATION_ERROR = "ValidationError";
    public static final String INTERNAL_SERVER_ERROR = "InternalServerError";
    public static final String NOT_FOUND_ERROR = "NotFoundError";
    public static final String ACCESS_DENIED_ERROR = "AccessDeniedError";
    public static final String UNAUTHENTICATED_ERROR = "UnauthenticatedError";

    // Error messages
    public static final String NOT_FOUND_ERROR_MSG = "%s with %s '%s' could not be found.";
    public static final String INTERNAL_SERVER_ERROR_MSG = "Something went wrong.";
    public static final String VALIDATION_ERROR_MSG = "Request failed with validation errors.";
    public static final String ACCESS_DENIED_MSG = "You don't have the right permissions to access this resource.";
    public static final String ERROR_HANDLER_MSG = "Exception %s was raised with request %s at %s";
    public static final String UNAUTHENTICATED_ERROR_MSG = ACCESS_DENIED_MSG + " Please log in.";
    public static final String DUPLICATE_KEY_MSG = "%s '%s' already exists";

}
