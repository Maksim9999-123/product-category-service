package com.example.productcategoryservice.service;

import com.example.productcategoryservice.dto.CreateUserDto;
import com.example.productcategoryservice.entity.Role;
import com.example.productcategoryservice.entity.User;
import com.example.productcategoryservice.mapper.UserMapper;
import com.example.productcategoryservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CreateUserDto createUserDto;

    private final PasswordEncoder passwordEncoder;

//    public Optional<User> findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//
//    public User save(CreateUserDto user) {
//        User newUser = userMapper.map(createUserDto);
//        user.setRole(Role.USER);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(newUser);
//    }
}
