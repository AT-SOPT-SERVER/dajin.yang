package org.sopt.exception;

public enum ErrorCode {
    TITLE_EMPTY("제목이 비었습니다."),
    TITLE_LENGTH("제목은 30자를 넘을 수 없습니다."),
    TITLE_DUPLICATE("중복된 제목입니다."),
    NOT_FOUND("존재하지 않는 게시글입니다."),
    TIME_ATTACK("마지막 게시글 작성 후 3분이 지나지않았습니다.");

    private final String msg;

    ErrorCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
