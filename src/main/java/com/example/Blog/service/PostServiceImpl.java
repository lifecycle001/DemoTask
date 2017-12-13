package com.example.Blog.service;

import com.example.Blog.model.Post;
import com.example.Blog.repository.PostRepository;
import com.example.Blog.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> showByPage(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    //CrudRepository method save works both save new and update
    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> getAll() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Post findOne(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public boolean exists(Post post) {
        return findByTitle(post.getTitle()) != null;
    }

    @Override
    public void remove(Long id) {
        postRepository.delete(id);
    }

    private Post findByTitle(String title) {
        List<Post> postList = getAll();
        for (Post post : postList) {
            if (post.getTitle().equals(title)) {
                return post;
            }
        }
        return null;
    }

}
