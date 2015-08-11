package main.com.anarcode.edu;

import main.com.anarcode.edu.AdderInterface;

public class Calculator {
    private AdderInterface adder;

    public Calculator(AdderInterface adder) {
        this.adder = adder;
    }

    public int add(String s) {
        return adder.getResult(s);
    }
}
