package main.com.anarcode.edu;

import java.util.ArrayList;
import java.util.List;

public class Parser implements ParserInterface{
    @Override
    public List<Integer> parseString(String s, Character delim) {
        if (s.length() == 0) {
            return new ArrayList<Integer>();
        }


        String[] numberStrings;
        if (delim == null)
            numberStrings = s.split(",|\n");
        else
            numberStrings = s.split(",|\n|"+delim);

        List<Integer> myList = new ArrayList<>();
        for (String str : numberStrings) {
            myList.add(Integer.parseInt(str));
        }

        return myList;
    }
}
