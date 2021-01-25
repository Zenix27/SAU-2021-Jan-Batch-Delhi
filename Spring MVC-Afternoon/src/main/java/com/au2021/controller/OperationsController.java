package com.au2021.controller;

import com.au2021.exception.DivideByZeroException;
import com.au2021.exception.LargeNumberException;
import com.au2021.service.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperationsController {

    @Autowired
    OperationsService service;

    @RequestMapping(value = "/arithmetic_operations", method = RequestMethod.GET)
    public String calculator(){
        return "arithmetic_operations";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String generateResult(@RequestParam String result, ModelMap model){
        model.put("result", result);
        return "result";
    }
    @RequestMapping(value = "/arithmetic_operations", method = RequestMethod.POST)
    public String handlePerformOperation(@RequestParam String num1, @RequestParam String num2,@RequestParam String operation, ModelMap model) throws LargeNumberException, DivideByZeroException{
        double result = service.performOperation(num1, num2, operation);
        if(result > 1000){
            throw new LargeNumberException();
        }
        model.put("result", result);
        return "result";
    }

}
