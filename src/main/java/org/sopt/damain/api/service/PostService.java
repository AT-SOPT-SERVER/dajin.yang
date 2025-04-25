package org.sopt.damain.api.service;

import org.aspectj.weaver.ast.Not;
import org.sopt.damain.api.exception.BaboEmptyException;
import org.sopt.damain.api.exception.NotFoundException;
import org.sopt.damain.api.exception.TimeAttackException;
import org.sopt.damain.api.exception.TitleDuplicateException;
import org.sopt.damain.core.Post;
import org.sopt.damain.core.repository.PostRepository;
import org.sopt.dto.PostListResponse;
import org.sopt.dto.PostRequest;
import org.sopt.dto.PostResponse;
import org.sopt.dto.PostUpdateRequest;
import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void createPost(PostRequest postRequest) {
        validateDuplicateTitle(postRequest.title());
        validateTimeRestriction(postRepository.findTopByOrderByCreatedAtDesc());

        Post post = new Post(postRequest.title());

        postRepository.save(post);
    }

    public PostResponse getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        return new PostResponse(post.getId(), post.getTitle());
    }

    @Transactional
    public void updatePostTitle(Long id, PostUpdateRequest postUpdateRequest) {
        validateDuplicateTitle(postUpdateRequest.title());

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        post.updateTitle(postUpdateRequest.title());
    }

    @Transactional
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());

        postRepository.delete(post);

    }

    public PostListResponse getAllPosts() {
        List<PostResponse> posts = postRepository.findAll().stream()
                .map(post -> new PostResponse(post.getId(), post.getTitle()))
                .toList();
        return new PostListResponse(posts);
    }

    public PostResponse searchPostsByKeyword(String keyword) {
        if (keyword==null||keyword.trim().isEmpty()) {
            throw new BaboEmptyException();
        }

        Post post = postRepository.findFirstByTitleContainingIgnoreCase(keyword)
                .orElseThrow(() -> new NotFoundException());
        return new PostResponse(post.getId(), post.getTitle());
    }

    private void validateDuplicateTitle(String title) {
        if (postRepository.existsByTitle(title)) {
            throw new TitleDuplicateException();

        }
    }

    private void validateTimeRestriction(java.util.Optional<Post> lastPost) {
        lastPost.ifPresent(post -> {
            Duration diff = Duration.between(post.getCreatedAt(), LocalDateTime.now());
            if (diff.getSeconds() < 180) {
                throw new TimeAttackException();
            }
        });
    }
}
