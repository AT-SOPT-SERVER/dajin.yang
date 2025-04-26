package org.sopt.damain.api.controller;

import org.sopt.damain.api.service.PostService;
import org.sopt.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<Response<Void>> createPost(@RequestBody PostRequest postRequest
    ) {
        postService.createPost(postRequest);
        return ResponseEntity.ok(Response.success(null));
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Response<PostResponse>> getPostById(@PathVariable Long id) {
        PostResponse postResponse = postService.getPostById(id);
        return ResponseEntity.ok(Response.success(postResponse));
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Response<Void>> updatePostTitle(@PathVariable Long id, @RequestBody PostUpdateRequest postUpdateRequest) {
        postService.updatePostTitle(id, postUpdateRequest);
        return ResponseEntity.ok(Response.success(null));
    }

    @DeleteMapping("posts/{id}")
    public ResponseEntity<Response<Void>> deletePostById(@PathVariable Long id) {
        postService.deletePostById(id);
        return ResponseEntity.ok(Response.success(null));
    }

    @GetMapping("/posts")
    public ResponseEntity<Response<PostListResponse>> getAllPosts() {
        PostListResponse postListResponse = postService.getAllPosts();
        return ResponseEntity.ok(Response.success(postListResponse));
    }

    @GetMapping("/posts/search")
    public ResponseEntity<Response<PostResponse>> searchPostsByKeyword(@RequestParam String keyword) {
        PostResponse postResponse = postService.searchPostsByKeyword(keyword);
        return ResponseEntity.ok(Response.success(postResponse));
    }
}
