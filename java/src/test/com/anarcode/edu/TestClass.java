package test.com.anarcode.edu;

import main.com.anarcode.edu.*;
import org.junit.Test;

import static junit.framework.Assert.*;

public class TestClass {

    @Test
    public void addZeroItemsReturnsZero()
    {
        MockAdder adder = new MockAdder();
        Calculator calculator = new Calculator(adder);
        int result = calculator.add("");
        assertEquals("", adder.getFormula());
        assertEquals(0, result);
    }

    @Test
    public void adderCommaSepertedReturnsCorrectValues() {
        Calculator calculator = new Calculator(new AdderCommaSeperated());
        assertEquals(0, calculator.add(""));
        assertEquals(5, calculator.add("5"));
        assertEquals(6, calculator.add("2,4"));
    }

    @Test
    public void adderNewlineAndCommaSeperatedReturnsCorrectValues() {
        Calculator calculator = new Calculator(new AdderTwoSeperators());
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(2, calculator.add("1,1"));
        assertEquals(3, calculator.add("2\n0\n1"));
    }

    @Test
    public void adderCustomSeperatedReturnsCorrectValues() {
        Calculator calculator = new Calculator(new AdderCustomSeperators());
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    private class MockAdder implements AdderInterface {

        private String formula;

        public String getFormula() {
            return formula;
        }

        @Override
        public int getResult(String s) {
            formula = s;
            return 0;
        }
    }
}
