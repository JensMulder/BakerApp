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
    public static final String NOT_FOUND_ERROR_MSG = "%s met %s '%s' kon niet worden gevonden.";
    public static final String INTERNAL_SERVER_ERROR_MSG = "Er ging iets mis.";
    public static final String VALIDATION_ERROR_MSG = "Request is gefaald met validatie errors.";
    public static final String ACCESS_DENIED_MSG = "Je hebt niet de juiste permissies om deze gegevens te mogen inzien.";
    public static final String ERROR_HANDLER_MSG = "Exception %s was raised with request %s at %s";
    public static final String UNAUTHENTICATED_ERROR_MSG = ACCESS_DENIED_MSG + " Log alsjeblieft eerst in.";
    public static final String DUPLICATE_KEY_MSG = "%s met waarde '%s' bestaat al";
    public static final String BAD_CREDENTIALS_MSG = "Gebruikersnaam en/of wachtwoord zijn incorrect.";
}
