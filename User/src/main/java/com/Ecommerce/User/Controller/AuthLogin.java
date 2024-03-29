package com.Ecommerce.User.Controller;

import com.Ecommerce.User.DTO.JwtRequest;
import com.Ecommerce.User.DTO.JwtResponse;
import com.Ecommerce.User.Entity.Users;
import com.Ecommerce.User.Exception.UserAlreadyExistException;
import com.Ecommerce.User.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthLogin {
    @Autowired
    AuthService authService;

    @PostMapping("/signIn")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest)
    {
        return new ResponseEntity<>(authService.login(jwtRequest), HttpStatus.OK);
    }
    @PostMapping("/signUp")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity register(@RequestBody Users user) throws UserAlreadyExistException {
        return authService.register(user);
    }
}
