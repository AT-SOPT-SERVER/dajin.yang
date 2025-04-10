package org.sopt.damain.api.service;

import org.sopt.common.TitleValidate;
import org.sopt.damain.core.Post;
import org.sopt.damain.core.repository.PostRepository;

import java.util.List;

import static org.sopt.common.TitleValidate.validate;

public class PostService {
    PostRepository postRepository =new PostRepository();

    public void createPost(Post post) {
        validate(post.getTitle(), postRepository.findAll());
        int id = postRepository.findAll().size() + 1;
        Post p = new Post(id, post.getTitle());
        postRepository.save(p);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(int id) {
        return postRepository.findPostById(id);
    }
    public boolean deletePostById(int id) {
        return postRepository.delete(id);
    }

    public void updatePostTitle(Post post) {
        validate(post.getTitle(), postRepository.findAll());
        postRepository.updateTitle(post.getId(), post.getTitle());
    }
}
