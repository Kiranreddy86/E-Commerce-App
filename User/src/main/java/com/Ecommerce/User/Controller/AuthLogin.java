package com.Ecommerce.User.Controller;

import com.Ecommerce.User.DTO.JwtRequest;
import com.Ecommerce.User.DTO.JwtResponse;
import com.Ecommerce.User.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthLogin {
    @Autowired
    AuthService authService;

    @PostMapping("/signIn")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest)
    {
        return new ResponseEntity<>(authService.login(jwtRequest), HttpStatus.OK);
    }
}
