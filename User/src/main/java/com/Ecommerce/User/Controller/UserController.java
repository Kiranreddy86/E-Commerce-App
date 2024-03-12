package com.Ecommerce.User.Controller;

import com.Ecommerce.User.DTO.JwtRequest;
import com.Ecommerce.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody JwtRequest userRequest){
        userService.register(userRequest);
    }
}
