package JensMulder.project.bakerapp.util.exceptions;

import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApiException {
    public UnauthorizedException() {
        super(HttpStatus.FORBIDDEN, ErrorConstants.ACCESS_DENIED_MSG);
    }
}
