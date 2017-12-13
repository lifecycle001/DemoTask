package com.example.Blog.repository;

import com.example.Blog.model.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDtoRepository extends CrudRepository<UserDto, Long> {

}
