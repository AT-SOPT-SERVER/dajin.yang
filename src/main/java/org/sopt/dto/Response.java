package org.sopt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Response<T>(
        int code,
        String msg,
        T data
) {
    public static <T> Response<T> success(T data, String msg) {
        return new Response<>(HttpStatus.OK.value(), msg, data);
    }

    public static <T> Response<T> success(T data) {
        return success(data, "응답 성공");
    }

    public static <T> Response<T> fail(int code, String msg) {
        return new Response<>(code, msg, null);
    }
}
