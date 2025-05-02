package org.sopt.domain.core.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.sopt.domain.core.QMember;
import org.sopt.domain.core.QPost;
import org.sopt.dto.res.PostTitleRes;
import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostQueryRepositoryImpl implements PostQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public PostQueryRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<PostTitleRes> searchByTitleOrNickname(String title, String nickname) {
        QPost post = QPost.post;
        QMember member = QMember.member;

        if (title != null && !title.isBlank()) {
            return jpaQueryFactory
                    .select(Projections.constructor(PostTitleRes.class, post.id, post.title,member.nickname))
                    .from(post)
                    .join(post.member,member)
                    .where(post.title.containsIgnoreCase(title))
                    .fetch();
        }

        if (nickname != null && !nickname.isBlank()) {
            return jpaQueryFactory
                    .select(Projections.constructor(PostTitleRes.class, post.id, post.title, member.nickname))
                    .from(post)
                    .join(post.member, member)
                    .where(member.nickname.containsIgnoreCase(nickname))
                    .fetch();
        }

        throw  new BusinessException(ErrorCode.MISSING_PATH_VARIABLE);
    }
}
