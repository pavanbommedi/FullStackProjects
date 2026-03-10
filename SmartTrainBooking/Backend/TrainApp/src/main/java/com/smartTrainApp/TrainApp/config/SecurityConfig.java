package com.smartTrainApp.TrainApp.config;

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
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizedUrl;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
        @Bean
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
            http.authorizeHttpRequests((requests) -> {
                ((AuthorizedUrl)requests.anyRequest()).authenticated();
            });
            http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            // http.formLogin(Customizer.withDefaults());
            http.httpBasic(Customizer.withDefaults());
            return (SecurityFilterChain)http.build();
        }
}