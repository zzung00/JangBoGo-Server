package com.example.jangbogo.controller;

import java.util.HashMap;

import com.example.jangbogo.dto.UserSigninRequest;
import com.example.jangbogo.dto.UserSigninResponse;
import com.example.jangbogo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public @ResponseBody UserSigninResponse signin (@RequestBody UserSigninRequest request) {
        UserSigninResponse response = new UserSigninResponse();
        
        return response;
    }
}
