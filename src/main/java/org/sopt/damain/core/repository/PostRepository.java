package org.sopt.damain.core.repository;

import org.sopt.damain.core.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PostRepository {
    List<Post> postList = new ArrayList<>();

    public void save(Post post) {
        postList.add(post);
    }

    public List<Post> findAll() {
        return postList;
    }

    public Optional<Post> findPostById(int id) {
        return postList.stream()
                .filter(post -> post.getId() == id)
                .findFirst();
    }

    public boolean delete(int id) {
        return postList.removeIf(post -> post.getId() == id);
    }

    public Optional<Post> createdAt() {
        if (postList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(postList.get(postList.size() - 1));
    }

    public List<Post> searchByKeword(String keyword) {
        List<Post> result = new ArrayList<>();
        for (Post post : postList) {
            if (post.getTitle().contains(keyword)) {
                result.add(post);
            }
        }
        return result;
    }

    public void loadFile(List<Post> posts) {
        postList.clear();
        postList.addAll(posts);
    }
}
