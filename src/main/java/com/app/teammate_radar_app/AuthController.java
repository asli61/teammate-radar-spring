package com.app.teammate_radar_app;

import com.app.teammate_radar_app.Exceptions.ResponseError;
import com.app.teammate_radar_app.Repos.User;
import com.app.teammate_radar_app.Repos.UserRepository;
import com.app.teammate_radar_app.Validation.PasswordConstraintValidator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.passay.RuleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    public class RegisterApiDto {
        @NotNull @NotBlank @Email
        private String email;
        @NotNull @NotBlank @Min(7)
        private String password;

        private int role;
    }


    @GetMapping("/login")
    public ResponseEntity<?> login()
    {
        return ResponseEntity.ok().body("okeyyy");
    }

    @GetMapping("/register")
    public ResponseEntity<?> register(@Valid RegisterApiDto requestObject, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());

            ResponseError responseError = new ResponseError("Validation failed", errors);
            return ResponseEntity.badRequest().body(responseError);
        }

        String email = requestObject.getEmail();
        String password = requestObject.getPassword();

        PasswordConstraintValidator passValidator = new PasswordConstraintValidator();

        RuleResult result = passValidator.validate(password);

        System.out.println(result.getDetails());

        if(!result.isValid()) {
            ResponseError responseError = new ResponseError("Validation failed", result.getDetails());
            return ResponseEntity.badRequest().body(responseError);
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(null);

        System.out.println(user);

        userRepository.save(user);

        return ResponseEntity.ok().body(user);
    }
}
