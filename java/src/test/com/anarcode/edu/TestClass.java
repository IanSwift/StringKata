package test.com.anarcode.edu;

import main.com.anarcode.edu.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestClass {

    @Test
    public void calculatorCalls_DelimeterDetector_Adder_Parser() {
        MockParser mockParser = new MockParser();
        MockAdder mockAdder = new MockAdder();
        MockDelimeterDetector mockDelimeterDetector = new MockDelimeterDetector();
        Calculator calculator = new Calculator(mockParser, mockAdder, mockDelimeterDetector);

        int result = calculator.add("//;\n2;3");

        assertEquals(0, result);
        assertEquals("//;\n2;3", mockDelimeterDetector.getLastParameters());
        assertEquals("2;3", mockParser.getFirstParameter());
        assertEquals(';', mockParser.getSecondParameter());
        assertEquals(new ArrayList<Integer>(), mockAdder.getLastParameters());


    }

    @Test
    public void parserParsesStringCorrectly() {
        Parser subject = new Parser();

        List<Integer> result = subject.parseString("", null);
        assertEquals(new ArrayList<Integer>(), result);
        result = subject.parseString("3", null);
        assertEquals(Arrays.asList(3), result);

        result = subject.parseString("5,6", null);
        assertEquals(Arrays.asList(5,6), result);
    }

    @Test
    public void adderReturnsCorrectValues() {
        Adder subject = new Adder();

        int result = subject.addList(new ArrayList<Integer>());
        assertEquals(0, result);
        result = subject.addList(Arrays.asList(1));
        assertEquals(1, result);
        result = subject.addList(Arrays.asList(1, 2, 3));
        assertEquals(6, result);
    }

    @Test
    public void parserWithNewlinesAndCommasReturnsCorrectValues() {
        Parser subject = new Parser();

        List<Integer> result = subject.parseString("1\n2", null);
        assertEquals(Arrays.asList(1,2), result);

        result = subject.parseString("1\n2,3", null);
        assertEquals(Arrays.asList(1,2,3), result);

    }

    @Test
    public void delimeterDetectorReturnsDelimeter() {
        DelimeterDetector delimeterDetector = new DelimeterDetector();

        char response1 = delimeterDetector.findDelimeter("//a\n3a4,5");
        assertEquals('a',response1);

        Character response2 = delimeterDetector.findDelimeter("3\n4");
        assertEquals(null, response2
        );
    }

    @Test
    public void parserPassedNewDelimeterUsesDelimeter() {
        Parser parser = new Parser();

        List<Integer> response = parser.parseString("3;5\n6,7", ';');
        assertEquals(Arrays.asList(3,5,6,7), response);
    }

    private class MockParser implements ParserInterface{

        private String lastParameters;
        private String firstParameter;
        private Character secondParameter;

        public String getLastParameters() {
            return lastParameters;
        }

        @Override
        public List<Integer> parseString(String s, Character delim) {
            this.firstParameter = s;
            this.secondParameter = delim;
            return new ArrayList<Integer>();
        }

        public String getFirstParameter() {
            return firstParameter;
        }

        public char getSecondParameter() {
            return secondParameter;
        }
    }

    private class MockAdder implements AdderInterface{
        private List<Integer> lastParameters;

        public List<Integer> getLastParameters() {
            return lastParameters;
        }

        @Override
        public int addList(List<Integer> input) {
            lastParameters = input;
            return 0;
        }
    }

    private class MockDelimeterDetector implements DelimeterDetectorInterface {


        private String lastParameters;

        @Override
        public Character findDelimeter(String s) {
            lastParameters = s;
            return ';';
        }

        public String getLastParameters() {
            return lastParameters;
        }
    }
}
