package com.Ecommerce.User.Service;

import com.Ecommerce.User.DTO.JwtRequest;
import com.Ecommerce.User.Entity.Users;
import com.Ecommerce.User.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public void register(JwtRequest userRequest) {
        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());
        Users user=new Users();
        user.setUsername(userRequest.getUsername());
        user.setPassword(encodedPassword);
        userRepo.save(user);
    }
}
