package org.sopt.damain.core.repository;

import org.sopt.damain.api.exception.NotFoundException;
import org.sopt.damain.core.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository {
    List<Post> postList = new ArrayList<>();

    public void save(Post post) {
        postList.add(post);
    }

    public List<Post> findAll() {
        return postList;
    }

    public Post findPostById(int id) {
        for (Post post : postList) {
            if (post.getId() == id) {
                return post;
            }
        }
        System.err.println("존재하지 않는 ID");
        return null;
    }
    public boolean delete(int id) {
        for (Post post : postList) {
            if (post.getId() == id) {
                postList.remove(postList.indexOf(post));
                return true;
            }
        }
        System.err.println("존재하지 않는 ID");
        return false;
    }

    public void updateTitle(int id, String title) {
        Post post = findPostById(id);
        if (post == null) {
            throw new NotFoundException();
        }
        post.updateTitle(title);
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
}
