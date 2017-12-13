package com.example.Blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// UserDto is the same as authorDto
@Entity
@Table(name = "USERS")
@JsonIgnoreProperties("postList")
public class UserDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String password;
    private String approvePassword;

    //"ROLE_USER"
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)

    //to prevent recursion when query works till StackOverflow
    @JsonManagedReference
    List<Post> postList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    //to prevent recursion when query works till StackOverflow
    @JsonBackReference
    private List<Comment> comments;

    public UserDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApprovePassword() {
        return approvePassword;
    }

    public void setApprovePassword(String approvePassword) {
        this.approvePassword = approvePassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
