package test.com.anarcode.edu;

import main.com.anarcode.edu.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertThat;

public class TestClass {

    @Test
    public void addWithEmptyStringReturnsZero() {
        List<Integer> integerArrayList = new ArrayList<Integer>();
        MockOperation operation = new MockOperation();
        MockParser parser = new MockParser();

        operation.setReturnValue(0);
        parser.setReturnValue(integerArrayList);

        Calculator calculator = new Calculator(parser, operation);
        int result = calculator.add("");
        assertEquals(0, result);

        assertEquals(integerArrayList, operation.getValues());
        assertEquals("", parser.getValues());
    }

    @Test
    public void addWithOneItemReturnsItem() {
        List<Integer> integerArrayList = Arrays.asList(3);
        MockParser parser = new MockParser();
        MockOperation operation = new MockOperation();

        parser.setReturnValue(integerArrayList);
        operation.setReturnValue(3);

        Calculator calculator = new Calculator(parser, operation);
        int result = calculator.add("3");
        assertEquals(3, result);
        assertEquals(integerArrayList, operation.getValues());
        assertEquals("3", parser.getValues());
    }

    @Test
    public void parserReturnsExpectedValues() {
        MyParser myParser = new MyParser();

        assertEquals(new ArrayList<Integer>(), myParser.parse(""));
        assertEquals(Arrays.asList(3), myParser.parse("3"));
        assertEquals(Arrays.asList(1,2), myParser.parse("1,2"));
        assertEquals(Arrays.asList(1,2,3), myParser.parse("1,2,3"));
    }

    public void adderReturnsExpectedValues() {
        MyAdder myAdder = new MyAdder();

        assertEquals(0, myAdder.operate(Arrays.<Integer>asList()));
        assertEquals(3, myAdder.operate(Arrays.<Integer>asList(3)));
        assertEquals(4, myAdder.operate(Arrays.<Integer>asList(3, 1)));
        assertEquals(5, myAdder.operate(Arrays.<Integer>asList(1,2,2)));
    }

    private class MockParser implements ParserInterface{
        private List<Integer> returnValue;
        private String values;

        @Override
        public List<Integer> parse(String s) {
            this.values = s;
            return returnValue;
        }

        public void setReturnValue(List<Integer> returnValue) {
            this.returnValue = returnValue;
        }

        public String getValues() {
            return values;
        }
    }

    private class MockOperation implements OperationInterface{
        private int returnValue;
        private List<Integer> values;

        @Override
        public int operate(List<Integer> values) {
            this.values = values;
            return returnValue;
        }

        public void setReturnValue(int returnValue) {
            this.returnValue = returnValue;
        }

        public List<Integer> getValues() {
            return values;
        }
    }
}
