package com.anik.productlist.controller;

import com.anik.productlist.dto.UserDTO;
import com.anik.productlist.entity.User;
import com.anik.productlist.security.JwtUtil;
import com.anik.productlist.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userDetailsService.createUser(userDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        List<String> roles = authentication.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).toList();

        UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername(), roles);
    }
}
