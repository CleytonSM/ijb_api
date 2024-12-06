package br.com.unifacef.ijb.configs;

//import br.com.unifacef.ijb.filter.JwtFilter;
import br.com.unifacef.ijb.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SecurityConfig {
    @Autowired
    ApplicationContext applicationContext;
    @Value("${host}")
    private String host;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(List.of(host));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(List.of("Authorization"));
                    config.setMaxAge(3600L);

                    return config;
                }))
                .addFilterBefore(applicationContext.getBean(JwtFilter.class), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/api/ijb/register/**").permitAll()
                        .requestMatchers("/api/ijb/login").permitAll()
                        .requestMatchers("/api/ijb/material/register").hasRole("ADMIN")
                        .requestMatchers("/api/ijb/material").hasRole("ADMIN")
                        .requestMatchers("/api/ijb/material/delete/**").hasRole("ADMIN")
                        .requestMatchers("/api/ijb/material/update/**").hasRole("ADMIN")
                        .requestMatchers("/api/ijb/outletProduct/register").hasRole("ADMIN")
                        .requestMatchers("/api/ijb/outletProduct/update/**").hasRole("ADMIN")
                        .requestMatchers("/api/ijb/outletProduct/delete/**").hasRole("ADMIN")
                        .requestMatchers("/api/ijb/outletProduct").hasRole("ADMIN"))
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder()
                .username("root")
                .password("123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }
}
