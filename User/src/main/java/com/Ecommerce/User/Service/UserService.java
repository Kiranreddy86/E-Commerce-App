package com.Ecommerce.User.Service;

import com.Ecommerce.User.DTO.JwtRequest;
import com.Ecommerce.User.Entity.Roles;
import com.Ecommerce.User.Entity.Users;
import com.Ecommerce.User.Exception.UserAlreadyExistException;
import com.Ecommerce.User.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public ResponseEntity register(JwtRequest jwtRequest, String role){
        Users user= new Users();
        if(userRepo.existsByUsername(jwtRequest.getUsername())){
            throw new UserAlreadyExistException("Aleady User Exists");
        }
        String encodedPassword = passwordEncoder.encode(jwtRequest.getPassword());
        user.setUsername(jwtRequest.getUsername());
        user.setPassword(encodedPassword);
        Roles userRole = new Roles();
        userRole.setName(role);
        Set<Roles> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        return ResponseEntity.ok(userRepo.save(user));
    }
}

