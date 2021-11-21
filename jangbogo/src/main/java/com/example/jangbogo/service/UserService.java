package com.example.jangbogo.service;

import com.example.jangbogo.domain.User;
import com.example.jangbogo.dto.UserDTO;
import com.example.jangbogo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO signUp(String username, String password) {
        System.out.println(username + password);
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user = userRepository.save(user);
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            return userDTO;
        } else {
            return null;
        }

    }

    public UserDTO signIn(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);
        if (userOptional.isPresent()) {
            UserDTO userDTO = modelMapper.map(userOptional.get(), UserDTO.class);
            return userDTO;
        }
        return null;
    }
}
