package org.sopt.damain.api.service;

import org.sopt.damain.core.Post;
import org.sopt.damain.core.repository.PostRepository;

import java.util.List;

import static org.sopt.common.TitleValidate.validate;

public class PostService {
    PostRepository postRepository =new PostRepository();

    public void createPost(Post post) {
        postRepository.save(post);
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

    public void updatePostTitle(int id, String title) {
        validate(title, postRepository.findAll());
        postRepository.updateTitle(id, title);
    }
}
