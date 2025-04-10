package org.sopt.damain.api;

import org.sopt.exception.BusinessException;

public class GlobalExceptionHandler {
    public static void handler(BusinessException ex) {
        System.out.println(ex.getErrorCode().getMsg());
    }
}
