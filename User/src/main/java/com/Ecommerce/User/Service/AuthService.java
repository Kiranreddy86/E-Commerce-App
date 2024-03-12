package com.Ecommerce.User.Service;

import com.Ecommerce.User.DTO.JwtRequest;
import com.Ecommerce.User.DTO.JwtResponse;
import com.Ecommerce.User.Entity.Users;
import com.Ecommerce.User.JWT.JwtAuthenticationHelper;
import com.Ecommerce.User.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtAuthenticationHelper jwtHelper;

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    UserRepo userRepo;

    public JwtResponse login(JwtRequest jwtRequest) {
        Users user=userRepo.findByUsername(jwtRequest.getUsername()).get();
        JwtResponse response=new JwtResponse();
        response.setUsername(user.getUsername());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        this.doAuthenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtHelper.generateToken(userDetails);
        response.setToken(String.valueOf(JwtResponse.builder().token(token).build()));
        return response;
    }

    private void doAuthenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            manager.authenticate(authenticationToken);

        }catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid Username or Password");
        }
    }
}
