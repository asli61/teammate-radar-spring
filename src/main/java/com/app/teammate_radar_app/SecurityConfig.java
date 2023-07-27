package com.app.teammate_radar_app;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final PasswordEncoder pwEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();



    @Bean
    UserDetailsService authentication() {
        UserDetails peter = User.builder()
                .username("peter")
                .password(pwEncoder.encode("ppassword"))
                .roles("USER")
                .build();
        UserDetails jodie = User.builder()
                .username("jodie")
                .password(pwEncoder.encode("jpassword"))
                .roles("USER", "ADMIN")
                .build();



        System.out.println("Peter's password: " + peter.getPassword());
        System.out.println("Jodie's password: " + jodie.getPassword());

        return new InMemoryUserDetailsManager(peter, jodie);

    }
}
