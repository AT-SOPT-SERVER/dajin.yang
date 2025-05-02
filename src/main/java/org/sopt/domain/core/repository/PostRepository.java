package org.sopt.domain.core.repository;

import org.sopt.domain.core.Post;
import org.sopt.dto.res.PostDetailsRes;
import org.sopt.dto.res.PostTitleRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    boolean existsByTitle(String title);

    @Query("SELECT new org.sopt.dto.res.PostTitleRes(p.id, p.title, m.nickname) " +
            "FROM Post p JOIN Member m ON p.memberId = m.id " +
            "ORDER BY p.createdAt DESC")
    List<PostTitleRes> findAllPostTitlesWithNickname();

    @Query("SELECT new org.sopt.dto.res.PostDetailsRes(p.id, p.title, p.content, p.member.nickname) " +
            "FROM Post p WHERE p.id = :postId")
    Optional<PostDetailsRes> findPostDetailsById(@Param("postId") Long postId);

}