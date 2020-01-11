package br.com.itss.SysParkingManagement.controller;

import br.com.itss.SysParkingManagement.model.User;
import br.com.itss.SysParkingManagement.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return this.userRepository.save(user);
    }
}
