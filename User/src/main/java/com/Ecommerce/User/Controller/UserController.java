package com.Ecommerce.User.Controller;

import com.Ecommerce.User.DTO.JwtRequest;
import com.Ecommerce.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity register(@RequestBody @Valid JwtRequest userRequest, String role) throws CloneNotSupportedException {
        return userService.register(userRequest,role);
    }
}
