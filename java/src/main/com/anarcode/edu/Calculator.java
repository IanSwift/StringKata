package main.com.anarcode.edu;

import test.com.anarcode.edu.TestClass;

import java.util.List;

public class Calculator {
    private ParserInterface parser;
    private OperationInterface operation;

    public Calculator(ParserInterface parser, OperationInterface operation) {
        this.parser = parser;
        this.operation = operation;
    }

    public int add(String s) {
        List<Integer> values = parser.parse(s);
        return operation.operate(values);
    }
}
