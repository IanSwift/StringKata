package main.com.anarcode.edu;

import main.com.anarcode.edu.AdderInterface;

public class AdderTwoSeperators implements AdderInterface {
    @Override
    public int getResult(String s) {
        if (s == "") {
            return 0;
        }
        String[] split = s.split(",|(\\n)");
        int augend = 0;
        for (String addend : split) {
            augend += Integer.parseInt(addend);
        }
        return augend;

    }
}
