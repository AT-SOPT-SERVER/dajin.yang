package org.sopt.controller;

import org.sopt.damain.Post;
import org.sopt.service.PostService;

import java.util.List;

public class PostController {
    private PostService postService = new PostService();
    private int postId;

    public void createPost(String title) {
        Post post = new Post(postId++, title);

        postService.createPost(post);
    }

    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    public Post getPostById(int postId) {
        return postService.getPostById(postId);
    }

    public boolean deletePostById(int postId) {
        return postService.deletePostById(postId);
    }
}
