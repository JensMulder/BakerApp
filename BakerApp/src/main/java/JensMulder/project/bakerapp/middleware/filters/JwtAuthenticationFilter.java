package JensMulder.project.bakerapp.middleware.filters;

import JensMulder.project.bakerapp.data.BakerUserDetailsService;
import JensMulder.project.bakerapp.util.auth.AuthenticationFacade;
import JensMulder.project.bakerapp.util.auth.JwtUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final Logger logger;
    private final BakerUserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

    private static final String TOKEN_TYPE = "Bearer ";

    public JwtAuthenticationFilter(Logger logger, BakerUserDetailsService userDetailsService, JwtUtils jwtUtils) {
        this.logger = logger;
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain
    )
            throws ServletException, IOException {
        try {
            var jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                var username = jwtUtils.getUserNameFromJwtToken(jwt);

                var userDetails = userDetailsService.loadUserByUsername(username);
                var authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                AuthenticationFacade.setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {0}", e);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(TOKEN_TYPE)) {
            return headerAuth.substring(TOKEN_TYPE.length());
        }

        return null;
    }
}
