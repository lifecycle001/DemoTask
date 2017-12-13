package com.example.Blog.controller;

import com.example.Blog.model.Post;
import com.example.Blog.model.UserDto;
import com.example.Blog.service.interfaces.PostService;
import com.example.Blog.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @RequestMapping(value = "/pageable", method = RequestMethod.GET)
    ResponseEntity<Page<Post>> list(Pageable pageable) {
        Page<Post> posts = postService.showByPage(pageable);
        logger.info("get all by page using default page size form properties " + posts);
        return new ResponseEntity<Page<Post>>(posts, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Post> getPostById(@PathVariable(value = "id") Long id) {
        Post newPost = postService.findOne(id);

        if (newPost == null) {
            logger.info("getting newPost with id " + id + " not found");
            return new ResponseEntity<Post>(newPost, HttpStatus.NOT_FOUND);
        }

        logger.info("getPostById id " + id);
        return new ResponseEntity<Post>(newPost, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createPost(@RequestBody Post newPost, UriComponentsBuilder ucBuilder,
                                           Principal principal) {

        if (postService.exists(newPost)) {
            logger.info("a post with title " + newPost.getTitle() + " already exists");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }


        String name = principal.getName();
        logger.info("Logged in user " + name);
        UserDto loggedInUser = userService.findOne(name);
        newPost.setUser(loggedInUser);
        postService.save(newPost);

        logger.info("Created new newPost id " + newPost.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/posts/{id}").buildAndExpand(newPost.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Post> updatePost(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Post postDetails) {
        Post post = postService.findOne(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());

        postService.save(post);

        Post updatedPOst = postService.findOne(post.getId());
        return ResponseEntity.ok(updatedPOst);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletePost(@PathVariable(value = "id") Long id) {
        logger.info("deleting post with id " + id);
        Post targetPost = postService.findOne(id);

        if (targetPost == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        postService.remove(targetPost.getId());
        logger.info("remove targetPost " + targetPost.getId());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}