package com.example.jangbogo.controller;

import java.util.HashMap;

import com.example.jangbogo.domain.User;
import com.example.jangbogo.dto.UserDTO;
import com.example.jangbogo.repository.UserRepository;
import com.example.jangbogo.service.CartService;

import com.example.jangbogo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public @ResponseBody UserDTO signIn(@RequestParam String username, @RequestParam String password) {
        return userService.signIn(username, password);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public @ResponseBody UserDTO signUp(@RequestBody HashMap<String, Object> request) {
        String username = (String) request.get("username");
        String password = (String) request.get("password");
        return userService.signUp(username, password);
    }
}
