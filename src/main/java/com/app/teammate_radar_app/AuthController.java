package com.app.teammate_radar_app;

import com.app.teammate_radar_app.Repos.UserRepository;
import jakarta.el.BeanNameResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserRepository userRepository;
    BeanNameResolver context;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/register")
    public void register(/*@RequestBody*/)
    {


        //return userRepository.save(product);
    }
}
