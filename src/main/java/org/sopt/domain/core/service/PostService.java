package org.sopt.domain.core.service;

import org.sopt.common.Tag;
import org.sopt.domain.core.Post;
import org.sopt.domain.core.repository.PostQueryRepository;
import org.sopt.domain.core.repository.PostRepository;
import org.sopt.dto.req.PostContentReq;
import org.sopt.dto.req.PostReq;
import org.sopt.dto.req.PostTitleReq;
import org.sopt.dto.res.PostDetailsRes;
import org.sopt.dto.res.PostTitleListRes;
import org.sopt.dto.res.PostTitleRes;
import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostQueryRepository postQueryRepository;

    public PostService(PostRepository postRepository, PostQueryRepository postQueryRepository) {
        this.postQueryRepository = postQueryRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public void createPost(PostReq postReq, String tag, Long memberId) {
        if (postRepository.existsByTitle(postReq.title())) {
            throw new BusinessException(ErrorCode.TITLE_DUPLICATE);
        }

        Tag convertedTag = Tag.fromString(tag);

        Post post = new Post(postReq.title(), postReq.content(), memberId, convertedTag);
        postRepository.save(post);
    }

    public PostTitleListRes getAllPostTitle () {
        List<PostTitleRes> postTitleRes = postRepository.findAllPostTitlesWithNickname();

        return new PostTitleListRes(postTitleRes);
    }

    public PostDetailsRes getDetailsPost(Long postId) {
        return postRepository.findPostDetailsById(postId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_POST));
    }

    @Transactional
    public PostTitleReq updatePostTitle(Long userId, Long postId, PostTitleReq postTitleReq) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_POST));

        if (!post.getMemberId().equals(userId)) {
            throw new BusinessException(ErrorCode.FORBIDDEN_USER);
        }

        if (postTitleReq.title() != null) {
            post.updateTitle(postTitleReq.title());
        }

        return new PostTitleReq(post.getTitle());
    }

    @Transactional
    public PostContentReq updatePostContent(Long userId, Long postId, PostContentReq postContentReq) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_POST));

        if (!post.getMemberId().equals(userId)) {
            throw new BusinessException(ErrorCode.FORBIDDEN_USER);
        }

        if (postContentReq.content() != null) {
            post.updateContent(postContentReq.content());
        }

        return new PostContentReq(post.getTitle());
    }

    @Transactional
    public void deletePostById(Long userId, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_POST));

        if (!post.getMemberId().equals(userId)) {
            throw new BusinessException(ErrorCode.FORBIDDEN_USER);
        }

        postRepository.delete(post);
    }

    public PostTitleListRes searchTitleAndNickname(String title, String nickname) {
        List<PostTitleRes> result = postQueryRepository.searchByTitleOrNickname(title, nickname);

        if (result.isEmpty()) {
            if (title != null) {
                throw new BusinessException(ErrorCode.NOT_FOUND_POST);
            }
            if (nickname != null) {
                throw new BusinessException(ErrorCode.NOT_FOUND_USER);
            }
        }

        return new PostTitleListRes(result);
    }
}