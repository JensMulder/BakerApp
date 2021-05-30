package JensMulder.project.bakerapp.middleware;

import JensMulder.project.bakerapp.core.constants.ErrorConstants;
import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {
    private final Logger logger;
    private final ApiResponseFactory responseFactory;

    public AuthEntryPoint(Logger logger, ApiResponseFactory responseFactory) {
        this.logger = logger;
        this.responseFactory = responseFactory;
    }

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.error(
                String.format(ErrorConstants.ERROR_HANDLER_MSG, e.toString(), httpServletRequest.toString(), this.getClass().getName())
        );

        httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(),  "Error: Unauthorized");
    }
}
