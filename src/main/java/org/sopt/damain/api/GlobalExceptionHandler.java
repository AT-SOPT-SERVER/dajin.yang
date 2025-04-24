package org.sopt.damain.api;

import org.sopt.dto.Response;
import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Response<Void>> handlerBusinessException(BusinessException ex) {
        ErrorCode errorCode = ex.getErrorCode();

        Response<Void> response = Response.fail(errorCode.getCode(), errorCode.getMsg());

        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handlerException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 내부 오류입니다."));
    }
}
