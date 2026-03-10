package com.smartTrainApp.TrainApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

// package com.smartTrainApp.TrainApp.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//                 .csrf(csrf -> csrf.disable())   // disable csrf for h2
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/h2-console/**").permitAll()
//                         .anyRequest().authenticated()
//                 )
//                 .headers(headers -> headers
//                         .frameOptions(frame -> frame.disable())  // allow iframe
//                 )
//                 .httpBasic(Customizer.withDefaults());

        

//         return http.build();
//     }
// }

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //Without @EnableWebSecurity, security filters are not registered.
//basic authentication with stateless session and in-memory users using Spring Security in a Spring Boot application.
@EnableMethodSecurity
public class SecurityConfig{
    @Autowired
    DataSource dataSource;
        @Bean
        //defining how the security filters should behave.
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
        //HttpSecurity → builds SecurityFilterChain
        {
            //Every request must be authenticated
        http.authorizeHttpRequests(auth -> auth
        .requestMatchers("/h2-console/**").permitAll()
        .anyRequest().authenticated()
            );
            //But Spring Security blocks iframes by default using:
            //
            http.headers(headers -> headers.frameOptions(frame -> frame.disable()));
            //By default, Spring Security enables CSRF protection.
            //The H2 console uses POST requests internally which will be blocked.
            http.csrf(csrf -> csrf
            .ignoringRequestMatchers("/h2-console/**"));
            //This configures how authentication state is stored.
            http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            // http.formLogin(Customizer.withDefaults());
            //This enables HTTP Basic Authentication.
            //Authorization: Basic base64(username:password)
            http.httpBasic(Customizer.withDefaults());
            return (SecurityFilterChain)http.build();
        }
        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        //In-Memory Authentication
        // @Bean
        // public UserDetailsService userDetailsService(){
        //     UserDetails user1 = User.withUsername("user1")
        //     //Spring expects encoded passwords.
        //         .password("{noop}userPass").roles("USER").build();
            
        //     UserDetails admin = User.withUsername("admin")
        //         .password("{noop}adminPass").roles("ADMIN").build();
            
        //     JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        //     userDetailsManager.createUser(user1);
        //     userDetailsManager.createUser(admin);
        //     return userDetailsManager;
        // }
}