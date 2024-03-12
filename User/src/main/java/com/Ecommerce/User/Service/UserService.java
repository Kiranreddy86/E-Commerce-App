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

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

}

