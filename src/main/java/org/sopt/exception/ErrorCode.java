package org.sopt.exception;

public enum ErrorCode {
    TITLE_EMPTY(40001, "제목은 비어있을 수 없습니다."),
    TITLE_LENGTH(40002, "제목은 30자를 넘을 수 없습니다."),
    TIME_ATTACK(40003, "마지막 게시글 작성 시간 3분 후에 작성이 가능합니다."),

    NOT_FOUND_URL(40401, "지원하지 않는 URL입니다."),
    NOT_FOUND(40402, "존재하지 않는 게시물입니다."),

    BAD_REQUEST_METHOD(40501, "잘못된 HTTP method 요청입니다."),

    TITLE_DUPLICATE(40901, "중복된 게시글 제목입니다.");

    private final int code;
    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
