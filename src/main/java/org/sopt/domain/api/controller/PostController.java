package org.sopt.domain.api.controller;

import org.sopt.domain.core.service.PostService;
import org.sopt.dto.Response;
import org.sopt.dto.req.PostContentReq;
import org.sopt.dto.req.PostReq;
import org.sopt.dto.req.PostTitleReq;
import org.sopt.dto.res.PostDetailsRes;
import org.sopt.dto.res.PostTitleListRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<Response<Void>> createPost(
            @RequestHeader Long userId,
            @RequestParam String tag,
            @RequestBody PostReq postReq) {
        postService.createPost(postReq, tag, userId);
        return ResponseEntity.ok(Response.success(null));
    }

    @GetMapping("/posts")
    public ResponseEntity<Response<PostTitleListRes>> getAllPostTitle(
    ) {
        PostTitleListRes postTitleListRes = postService.getAllPostTitle();
        return ResponseEntity.ok(Response.success(postTitleListRes));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Response<PostDetailsRes>> getDetailsPost(@PathVariable Long postId) {
        PostDetailsRes postDetailsRes = postService.getDetailsPost(postId);
        return ResponseEntity.ok(Response.success(postDetailsRes));
    }

    @PatchMapping("/posts/title/{postId}")
    public ResponseEntity<Response<Void>> updatePostTitle(
            @RequestHeader Long userId,
            @PathVariable Long postId,
            @RequestBody PostTitleReq postTitleReq
    ) {
        postService.updatePostTitle(userId, postId, postTitleReq);
        return ResponseEntity.ok(Response.success(null));
    }

    @PatchMapping("/posts/content/{postId}")
    public ResponseEntity<Response<PostContentReq>> updatePostContent(
            @RequestHeader Long userId,
            @PathVariable Long postId,
            @RequestBody PostContentReq postContentReq
    ) {
        postService.updatePostContent(userId, postId, postContentReq);
        return ResponseEntity.ok(Response.success(null));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Response<Void>> deletePostById(
            @RequestHeader Long userId,
            @PathVariable Long postId
    ) {
        postService.deletePostById(userId, postId);
        return ResponseEntity.ok(Response.success(null));
    }

    @GetMapping("/posts/search")
    public ResponseEntity<Response<PostTitleListRes>> searchTitleAndNickname(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String nickname
    ) {
        PostTitleListRes postTitleListRes = postService.searchTitleAndNickname(title, nickname);
        return ResponseEntity.ok(Response.success(postTitleListRes));
    }
}
