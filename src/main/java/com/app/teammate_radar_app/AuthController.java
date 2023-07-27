package com.app.teammate_radar_app;

import com.app.teammate_radar_app.Repos.User;
import com.app.teammate_radar_app.Repos.UserRepository;
import jakarta.el.BeanNameResolver;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    public class RegisterApiDto {
        @NotNull
        private String email;
        @NotNull @NotBlank
        private String password;

        private int role;
    }

    @Autowired
    public PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public ResponseEntity<?> register(@Valid RegisterApiDto requestObject, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        String email = requestObject.getEmail();
        String password = requestObject.getPassword();

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(null);

        System.out.println(user);

        userRepository.save(user);

        return ResponseEntity.ok().body(user);
    }
}
