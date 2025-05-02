package org.sopt.dto;

public record ErrorResponse(
        int code,
        String msg
) {
}
