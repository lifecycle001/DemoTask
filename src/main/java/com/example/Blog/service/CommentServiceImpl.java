package com.example.Blog.service;

import com.example.Blog.model.Comment;
import com.example.Blog.model.Post;
import com.example.Blog.service.interfaces.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public void save(Comment comment) {

    }

    @Override
    public List<Post> getAllForPost(Post post) {
        return null;
    }

    @Override
    public Post findOne(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
