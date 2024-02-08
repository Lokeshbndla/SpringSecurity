package com.rest.SecurityConfig;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	public HttpSecurity filterChain(HttpSecurity http) throws Exception {
        
	return	 http.csrf(AbstractHttpConfigurer::disable)
         .authorizeHttpRequests(auth -> auth
                 .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                 .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                 .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                 .requestMatchers("/login/**").permitAll()
                 .anyRequest().authenticated())
         .httpBasic(withDefaults())
         .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		

	
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // No need for the withDefaults() method here
}
