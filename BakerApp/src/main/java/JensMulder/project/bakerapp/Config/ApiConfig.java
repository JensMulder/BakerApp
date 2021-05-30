package JensMulder.project.bakerapp.Config;

import JensMulder.project.bakerapp.util.factories.ApiResponseFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.MethodParameter;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Field;

import static java.util.Optional.ofNullable;

@Configuration
public class ApiConfig {
    private final Environment env;

    ApiConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public ApiResponseFactory responseFactory() {
        return new ApiResponseFactory();
    }

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();

        // TODO: Add mappings...

        return mapper;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(env.getProperty("client.url"));
            }
        };
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Logger logger(final InjectionPoint ip) {
        return LoggerFactory.getLogger(ofNullable(ip.getMethodParameter())
                .<Class>map(MethodParameter::getContainingClass)
                .orElseGet( () ->
                        ofNullable(ip.getField())
                                .map(Field::getDeclaringClass)
                                .orElseThrow (IllegalArgumentException::new)
                )
        );
    }
}
