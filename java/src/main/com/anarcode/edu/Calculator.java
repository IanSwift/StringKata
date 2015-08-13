package main.com.anarcode.edu;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private ParserInterface parser;
    private AdderInterface adder;
    private DelimeterDetectorInterface delimeterDetector;

    public Calculator(ParserInterface parser, AdderInterface adder, DelimeterDetectorInterface delimeterDetector) {
        this.parser = parser;
        this.adder = adder;
        this.delimeterDetector = delimeterDetector;
    }

    public int add(String s) {
        Character c = delimeterDetector.findDelimeter(s);
        List<Integer> list = new ArrayList<>();
        if (c != null)
        {
            list = parser.parseString(s.substring(s.indexOf("\n")+1), c);
        }
        else
        {
            list = parser.parseString(s, null);
        }
        return adder.addList(list);
    }
}
