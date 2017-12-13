package com.example.Blog.service;

import com.example.Blog.model.UserDto;
import com.example.Blog.repository.UserDtoRepository;
import com.example.Blog.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDtoRepository userRepository;

    @Override
    public UserDto findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserDto findOne(String name) {
        List<UserDto> users = (List<UserDto>) userRepository.findAll();
        UserDto find = users.stream().filter(userDto
                -> userDto.getUserName().equals(name)).findAny().get();

        return find;
    }
}
