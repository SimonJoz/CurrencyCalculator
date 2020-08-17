package com.simonjoz.currencyconverter.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APILimitExceptionHandler {


    @ExceptionHandler(APILimitException.class)
    public String apiLimitHandler() {
        return "err";
    }
}
