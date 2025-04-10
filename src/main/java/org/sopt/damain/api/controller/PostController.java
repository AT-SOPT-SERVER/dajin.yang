package org.sopt.damain.api.controller;

import org.sopt.damain.core.Post;
import org.sopt.damain.api.service.PostService;
import org.sopt.exception.BusinessException;

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

    public boolean updatePostTitle(int id, String title) {
        try {
            postService.updatePostTitle(id, title);
            return true;
        } catch (BusinessException exception) {
            return false;
        }
    }
}
