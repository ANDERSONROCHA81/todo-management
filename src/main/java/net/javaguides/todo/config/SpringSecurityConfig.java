package net.javaguides.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((autorize) -> {
                    autorize.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
                    autorize.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN");
                    autorize.requestMatchers(HttpMethod.DELETE, "api/**").hasRole("ADMIN");
                    autorize.requestMatchers(HttpMethod.GET, "api/**").hasAnyRole("ADMIN", "USER");
                    autorize.requestMatchers(HttpMethod.PATCH, "api/**").hasAnyRole("ADMIN", "USER");
//                    autorize.requestMatchers(HttpMethod.GET, "api/**").permitAll();
                    autorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails anderson = User.builder()
                .username("anderson")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(anderson, admin);
    }
}
