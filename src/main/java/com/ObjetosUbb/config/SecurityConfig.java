package com.ObjetosUbb.config;

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    //Endpoint level authorization
        //matcher
        //1. AnyRequest
        //2. RequestMatcher
        //3. RequestMatcher with HttpMethod

    //
    //---Authorization rule
    /*
     * 1. PermitAll
     * 2. DenyAll
     * 3. Authenticated
     * 4. HasRole
     * 5. HasAuthority
     * 6. Access SpEL - Spring Expression Lenguage
     */

    /* 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
            .httpBasic()
            .and().authorizeHttpRequests(
                authorize -> authorize.anyRequest().permitAll()
            )

            .build();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new InMemoryUserDetailsManager(
            User.withUsername("user")
                .password(passwordEncoder.encode("hola123"))
                .authorities("read","write")
                .roles("USER")
                .build(),
            User.withUsername("admin")
                .password(passwordEncoder.encode("password123"))
                .authorities("read","write")
                .roles("ADMIN")
                .build()
        );

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
*/