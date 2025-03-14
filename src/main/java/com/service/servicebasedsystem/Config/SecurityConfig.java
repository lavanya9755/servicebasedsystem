package  com.service.servicebasedsystem.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/client/register", "/company/register", "/css/**", "/js/**").permitAll() // Allow access to login, registration, and static resources
                .requestMatchers("/client/**").hasRole("CLIENT") // Client-specific routes
                .requestMatchers("/company/**").hasRole("COMPANY") // Company-specific routes
                .anyRequest().authenticated() // All other requests require authentication
            )
            .formLogin(form -> form
                .loginPage("/login") // Custom login page
                .defaultSuccessUrl("/dashboard") // Redirect to dashboard after successful login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
                .permitAll()
            );

        return http.build();
    }
}