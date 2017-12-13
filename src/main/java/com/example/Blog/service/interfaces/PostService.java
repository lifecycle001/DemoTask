package com.example.Blog.service.interfaces;

import com.example.Blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    void save(Post post);

    List<Post> getAll();

    Post findOne(Long id);

    boolean exists(Post post);

    void remove(Long id);

    Page<Post> showByPage(Pageable pageable);
}
