package com.au2021.exception;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DivideByZeroException extends Exception{

    public DivideByZeroException() {
        super("Error : Divide by Zero");
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(value = DivideByZeroException.class)
    @ResponseBody
    public Map<String, String> handleDivideByZeroException() {
        Map<String, String> result = new HashMap<>();
        result.put("Operation", "/");
        result.put("Message", "Error : Divide by Zero");
        return result;
    }
}
