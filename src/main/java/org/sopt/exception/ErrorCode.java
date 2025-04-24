package org.sopt.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    TITLE_EMPTY(HttpStatus.BAD_REQUEST, 40001, "제목은 비어있을 수 없습니다."),
    TITLE_LENGTH(HttpStatus.BAD_REQUEST, 40002, "제목은 30자를 넘을 수 없습니다."),
    TIME_ATTACK(HttpStatus.BAD_REQUEST, 40003, "마지막 게시글 작성 시간 3분 후에 작성이 가능합니다."),

    NOT_FOUND_URL(HttpStatus.NOT_FOUND, 40401, "지원하지 않는 URL입니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, 40402, "존재하지 않는 게시물입니다."),

    BAD_REQUEST_METHOD(HttpStatus.METHOD_NOT_ALLOWED, 40501, "잘못된 HTTP method 요청입니다."),

    TITLE_DUPLICATE(HttpStatus.CONFLICT, 40901, "중복된 게시글 제목입니다."),

    BABO_EMPTY(HttpStatus.NOT_FOUND, 9999, "으이구 인간아 ᕙ( ︡과젝’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง 으이구 인간아 ᕙ( ︡’︡益’︠)ง");

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