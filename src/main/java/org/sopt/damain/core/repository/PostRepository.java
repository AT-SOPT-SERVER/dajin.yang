package org.sopt.damain.core.repository;

import org.sopt.damain.core.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findTopByOrderByCreatedAtDesc();

    boolean existsByTitle(String title);

    Optional<Post> findFirstByTitleContainingIgnoreCase(String keyword);
}