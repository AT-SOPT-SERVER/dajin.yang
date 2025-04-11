package org.sopt.damain.api.service;

import org.sopt.common.FileManager;
import org.sopt.damain.api.exception.TimeAttackException;
import org.sopt.damain.core.Post;
import org.sopt.damain.core.repository.PostRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.sopt.common.utils.TitleValidate.duplicate;
import static org.sopt.common.utils.IdGenerator.generateId;
public class PostService {
    PostRepository postRepository =new PostRepository();

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
        postRepository.updateTitle(id, title);
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
