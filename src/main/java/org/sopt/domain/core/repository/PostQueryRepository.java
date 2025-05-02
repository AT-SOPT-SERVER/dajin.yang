package org.sopt.domain.core.repository;

import org.sopt.domain.core.Post;
import org.sopt.dto.res.PostTitleRes;

import java.util.List;

public interface PostQueryRepository {
    List<PostTitleRes> searchByTitleOrNickname(String title, String nickname);
}
