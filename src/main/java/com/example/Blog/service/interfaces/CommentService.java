package com.example.Blog.service.interfaces;


import com.example.Blog.model.Comment;
import com.example.Blog.model.Post;

import java.util.List;

public interface CommentService {
    void save(Comment comment);

    List<Post> getAllForPost(Post post);

    Post findOne(Long id);

    void remove(Long id);
}
