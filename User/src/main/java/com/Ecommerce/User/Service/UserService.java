package com.Ecommerce.User.Service;

import com.Ecommerce.User.DTO.JwtRequest;
import com.Ecommerce.User.Entity.Roles;
import com.Ecommerce.User.Entity.Users;
import com.Ecommerce.User.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public void register(JwtRequest jwtRequest,String role) throws CloneNotSupportedException {
        Users user= userRepo.findByUsername(jwtRequest.getUsername()).get();
        if(user!=null){
            throw new CloneNotSupportedException("Already User Available");
        }
        String encodedPassword = passwordEncoder.encode(jwtRequest.getPassword());
        user.setUsername(jwtRequest.getUsername());
        user.setPassword(encodedPassword);
        Roles userRole = new Roles();
        userRole.setName(role);
        Set<Roles> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepo.save(user);
    }
}
