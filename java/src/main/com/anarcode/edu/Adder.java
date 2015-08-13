package main.com.anarcode.edu;

import java.util.List;

public class Adder implements AdderInterface{
    @Override
    public int addList(List<Integer> input) {
        int result = 0;
        for (int i : input)
            result += i;
        return result;
    }
}
