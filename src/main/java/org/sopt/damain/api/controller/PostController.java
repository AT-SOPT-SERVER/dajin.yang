package org.sopt.damain.api.controller;

import org.sopt.damain.api.GlobalExceptionHandler;
import org.sopt.damain.core.Post;
import org.sopt.damain.api.service.PostService;
import org.sopt.exception.BusinessException;

import java.util.List;

public class PostController {
    private PostService postService = new PostService();
    private int postId;

    public void createPost(String title) {
        postService.createPost(title);
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
        Post post = new Post(id, title);
        try {
            postService.updatePostTitle(post);
            return true;
        } catch (BusinessException ex) {
            GlobalExceptionHandler.handler(ex);
            return false;
        }
    }

    public List<Post> searchPostsByKeyword(String keyword) {
        return postService.searchPostsByKeyword(keyword);
    }

    public void saveFile() {
        postService.saveFile();
    }

    public void loadFile() {
        postService.loadFile();
    }
}
