package com.au2021.service;

import com.au2021.exception.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service
public class OperationsService {
    public double performOperation(String num1, String num2, String operation) throws DivideByZeroException {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);

        switch (operation) {
            case "add": {
                return n1 + n2;
            }
            case "subtract": {
                return n1 - n2;
            }
            case "multiply": {
                return n1 * n2;
            }
            case "divide": {
                if(n2 == 0) {
                    throw new DivideByZeroException();
                }
                return n1 / n2;
            }
        }
        return 0;
    }
}
