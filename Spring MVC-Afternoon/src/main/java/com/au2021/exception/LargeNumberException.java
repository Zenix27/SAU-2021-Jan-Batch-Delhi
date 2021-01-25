package com.au2021.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LargeNumberException extends Exception{
    public LargeNumberException(){
        super("The Result is too Large");
    }

    @ExceptionHandler(value = LargeNumberException.class)
    public String handleLargeNumberException() {
        return "large_number_exception";
    }
}
