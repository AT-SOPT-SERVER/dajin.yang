package org.sopt.service;

import org.sopt.damain.Post;
import org.sopt.repository.PostRepository;

import java.util.List;

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
}
