package com.anik.productlist.mapper;

import com.anik.productlist.dto.UserDTO;
import com.anik.productlist.entity.User;

public class UserMapper {
    public static UserDTO toUserDTO(User user){
        if(user == null) return null;
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
    }

    public static User toUserEntity(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
