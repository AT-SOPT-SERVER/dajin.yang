package org.sopt.damain.api.service;

import org.sopt.common.FileManager;
import org.sopt.damain.api.exception.NotFoundException;
import org.sopt.damain.api.exception.TimeAttackException;
import org.sopt.damain.core.Post;
import org.sopt.damain.core.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.sopt.common.utils.TitleValidate.duplicate;
import static org.sopt.common.utils.IdGenerator.generateId;

@Service
public class PostService {
    // PostRepository postRepository =new PostRepository();

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostService() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            saveFile();
        }));
    }

    public void createPost(String title) {
        duplicate(title, postRepository.findAll());

        postRepository.createdAt().ifPresent(lastPost->{
            Duration diff = Duration.between(lastPost.getCreatedAt(), LocalDateTime.now());
            if (diff.getSeconds() < 180) {
                throw new TimeAttackException();
            }
        });

        Post post = new Post(generateId(), title);
        postRepository.save(post);

        System.out.println(post.getTitle());
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(int id) {
        return postRepository.findPostById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    public boolean deletePostById(int id) {
        boolean deleted = postRepository.delete(id);
        if (!deleted) {
            throw new NotFoundException();
        }
        return true;
    }

    public boolean updatePostTitle(int id, String title) {
        Post post = getPostById(id);
        post.updateTitle(title);
        return true;
    }

    public List<Post> searchPostsByKeyword(String keyword) {
        return postRepository.searchByKeword(keyword);
    }

    public void saveFile() {
        FileManager.saveFile(postRepository.findAll());
    }

    public void loadFile() {
        List<Post> post = FileManager.loadFile();
        postRepository.loadFile(post);
    }
}
