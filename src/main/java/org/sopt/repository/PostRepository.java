package org.sopt.repository;

import org.sopt.damain.Post;

import java.util.ArrayList;
import java.util.List;

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
}
