package max.demo.springbootkeycloak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * don't use KeycloakWebSecurityConfigurerAdapter
 * it extends WebSecurityConfigurerAdapter which is deprecated
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true) // allows using the @RolesAllowed annotation
public class WebSecurityConfig {

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /* any endpoint that does not require a specific role (is not having @RolesAllowed annotation)
         can be accessed only by authenticated user */
        http.authorizeHttpRequests()
                .anyRequest()
                .authenticated();

        // add configuration of authorization based on roles to oauth2ResourceServer
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter());

        return http.build();
    }

    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(new GrantedAuthoritiesConverter());
        return jwtConverter;
    }

}