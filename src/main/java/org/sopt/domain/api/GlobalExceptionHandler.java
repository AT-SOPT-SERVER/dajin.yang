package org.sopt.domain.api;

import org.sopt.dto.ErrorResponse;
import org.sopt.dto.Response;
import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handlerBusinessException(BusinessException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        return ResponseEntity.status(errorCode.getStatus())
                .body(new ErrorResponse(errorCode.getCode(), errorCode.getMsg()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Response<Void>> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        ErrorCode errorCode = ErrorCode.BAD_REQUEST_METHOD;
        Response<Void> response = Response.fail(errorCode.getCode(), errorCode.getMsg());
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Response<Void>> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        ErrorCode errorCode = ErrorCode.BAD_REQUEST_METHOD;
        Response<Void> response = Response.fail(errorCode.getCode(), errorCode.getMsg());
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Response<Void>> handleNoResourceFound(NoResourceFoundException ex) {
        ErrorCode errorCode = ErrorCode.NOT_FOUND_URL;
        Response<Void> response = Response.fail(errorCode.getCode(), errorCode.getMsg());
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response<Void>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        ErrorCode errorCode = ErrorCode.INVALID_REQUEST_BODY;
        Response<Void> response = Response.fail(errorCode.getCode(), errorCode.getMsg());
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<Response<Void>> handleMissingRequestHeader(MissingRequestHeaderException ex) {
        ErrorCode errorCode = ErrorCode.ID_BAD_REQUEST;
        Response<Void> response = Response.fail(errorCode.getCode(), errorCode.getMsg());
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<Response<Void>> handleMissingPathVariable(MissingPathVariableException ex) {
        ErrorCode errorCode = ErrorCode.MISSING_PATH_VARIABLE;
        Response<Void> response = Response.fail(errorCode.getCode(), errorCode.getMsg());
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handlerException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 내부 오류입니다."));
    }
}
