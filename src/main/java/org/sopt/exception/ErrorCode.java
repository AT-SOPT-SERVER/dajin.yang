package org.sopt.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    TITLE_EMPTY(HttpStatus.BAD_REQUEST, 40001, "제목은 비어있을 수 없습니다."),
    CONTENT_EMPTY(HttpStatus.BAD_REQUEST,40002, "내용은 비어있을 수 없습니다."),
    NICKNAME_EMPTY(HttpStatus.BAD_REQUEST, 40003, "닉네임은 비어있을 수 없습니다."),
    TITLE_LENGTH(HttpStatus.BAD_REQUEST, 40004, "제목은 30자를 넘을 수 없습니다."),
    CONTENT_LENGTH(HttpStatus.BAD_REQUEST, 40005, "제목은 1000자룰 넘을 수 없습니다."),
    NICKNAME_LENGTH(HttpStatus.BAD_REQUEST, 40006, "사용자 닉네임은 10자를 넘을 수 없습니다."),
    ID_BAD_REQUEST(HttpStatus.BAD_REQUEST, 40007, "잘못된 id 값입니다."),
    INVALID_REQUEST_BODY(HttpStatus.BAD_REQUEST, 40008, "요청 본문의 형식이 올바르지 않습니다."),
    MISSING_PATH_VARIABLE(HttpStatus.BAD_REQUEST, 40009, "필수 경로 변수 누락"),

    FORBIDDEN_USER(HttpStatus.FORBIDDEN, 40301, "권한이 없습니다."),

    NOT_FOUND_POST(HttpStatus.NOT_FOUND, 40402, "존재하지 않는 게시물입니다."),
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, 40402, "존재하지 않는 사용자입니다."),
    NOT_FOUND_URL(HttpStatus.NOT_FOUND, 40403, "지원하지 않는 URL입니다."),

    BAD_REQUEST_METHOD(HttpStatus.METHOD_NOT_ALLOWED, 40501, "잘못된 HTTP method 요청입니다."),

    NICKNAME_DUPLICATE(HttpStatus.CONFLICT, 40901, "중복된 닉네임입니다."),
    TITLE_DUPLICATE(HttpStatus.CONFLICT, 40902, "중복된 제목입니다.");

    private final HttpStatus status;
    private final int code;
    private final String msg;

    ErrorCode(HttpStatus status, int code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}