package com.anik.productlist.service;

import com.anik.productlist.dto.UserDTO;
import com.anik.productlist.entity.User;
import com.anik.productlist.mapper.UserMapper;
import com.anik.productlist.repository.UserRepository;
import com.anik.productlist.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    public UserDTO createUser(UserDTO userDTO){
        User user = UserMapper.toUserEntity(userDTO);
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        user = userRepository.save(user);
        return UserMapper.toUserDTO(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User Not Found!");
        }
        return new UserPrincipal(user.get());
    }
}
