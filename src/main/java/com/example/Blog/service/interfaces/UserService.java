package com.example.Blog.service.interfaces;


import com.example.Blog.model.UserDto;

public interface UserService {
    UserDto findOne(Long id);

    UserDto findOne(String name);
}
