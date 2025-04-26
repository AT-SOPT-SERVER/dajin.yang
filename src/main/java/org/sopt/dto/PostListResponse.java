package org.sopt.dto;

import java.util.List;
public record PostListResponse(
        List<PostResponse> postList
) {
}
