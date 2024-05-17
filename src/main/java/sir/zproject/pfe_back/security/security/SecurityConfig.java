package sir.zproject.pfe_back.security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    private final JwtFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(

                                        "/auth/**",
                                        "/v2/api-docs",
                                        "/v3/api-docs",
                                        "/v3/api-docs/**",
                                        "/swagger-resources",
                                        "/swagger-resources/**",
                                        "/configuration/ui",
                                        "/configuration/security",
                                        "/swagger-ui/**",
                                        "/webjars/**",
                                        "/swagger-ui.html"
                                ).permitAll()
                                .requestMatchers("/api/v1/admin/**").hasAuthority(AuthoritiesConstants.ADMIN)
                                .requestMatchers("/api/v1/secretaire/**").hasAuthority(AuthoritiesConstants.SECRETAIRE)
                                .requestMatchers("/api/v1/employe/**").hasAuthority(AuthoritiesConstants.EMPLOYE)
                                .requestMatchers("/api/v1/sup/**").hasAnyAuthority(AuthoritiesConstants.ADMIN, AuthoritiesConstants.SECRETAIRE)
                                .requestMatchers("/api/v1/all/**").hasAnyAuthority(AuthoritiesConstants.ADMIN, AuthoritiesConstants.EMPLOYE, AuthoritiesConstants.SECRETAIRE)
                                .requestMatchers("/api/v1/admin-employe/**").hasAnyAuthority(AuthoritiesConstants.ADMIN, AuthoritiesConstants.EMPLOYE)
                                .requestMatchers("/api/v1/employe-secretaire/**").hasAnyAuthority(AuthoritiesConstants.EMPLOYE, AuthoritiesConstants.SECRETAIRE)
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
