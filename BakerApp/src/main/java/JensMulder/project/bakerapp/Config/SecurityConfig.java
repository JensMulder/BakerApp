package JensMulder.project.bakerapp.Config;

import JensMulder.project.bakerapp.core.enums.BakerRoles;
import JensMulder.project.bakerapp.data.BakerUserDetailsService;
import JensMulder.project.bakerapp.middleware.AuthEntryPoint;
import JensMulder.project.bakerapp.middleware.filters.JwtAuthenticationFilter;
import JensMulder.project.bakerapp.util.auth.JwtUtils;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final BakerUserDetailsService userDetailsService;
    private final Logger logger;
    private final AuthEntryPoint authEntryPoint;
    private final JwtUtils jwtUtils;

    public SecurityConfig(
            Logger logger,
            BakerUserDetailsService userDetailsService,
            AuthEntryPoint authEntryPoint,
            JwtUtils jwtUtils
    ) {
        this.logger = logger;
        this.userDetailsService = userDetailsService;
        this.authEntryPoint = authEntryPoint;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter authenticationJwtTokenFilter() {
        return new JwtAuthenticationFilter(logger, userDetailsService, jwtUtils);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/**").permitAll()
                .antMatchers("/users/**").hasRole(BakerRoles.ADMIN.toString())
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
