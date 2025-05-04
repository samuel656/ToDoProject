package com.springboot.ToDoProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {

//    InMemoryUserDetailsManager
//    InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {

        UserDetails userDetails1 = createNewUser("Samuel", "Sam@0708");
        UserDetails userDetails2 = createNewUser("Swetha", "Swetha@0708");

        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private static UserDetails createNewUser(String username, String password) {
        UserDetails userDetails= User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles("USER","ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/error", "/webjars/**").permitAll()
                .anyRequest().authenticated()
        );

        http.formLogin(Customizer.withDefaults());
        http.logout(logout -> logout.permitAll());

        // Updated way (no deprecation warning)
        http.csrf(csrf -> csrf.disable());

        // H2 console
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

}
