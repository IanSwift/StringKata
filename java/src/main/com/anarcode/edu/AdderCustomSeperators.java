package main.com.anarcode.edu;

import main.com.anarcode.edu.AdderInterface;

public class AdderCustomSeperators implements AdderInterface {
    @Override
    public int getResult(String s) {
        String delimiter = "";
        if (s.length() >= 4 && s.substring(0,2).equals("//") && s.charAt(3) == '\n') {
            delimiter = String.valueOf(s.charAt(2));
            s = s.substring(4);
        }

        if (s == "") {
            return 0;
        }

        String regex = ",|(\\n)" + ((delimiter.length() > 0) ? "|" + delimiter : "");
        String[] split = s.split(regex);
        System.out.println("regex = " + regex);
        int augend = 0;
        for (String addend : split) {
            augend += Integer.parseInt(addend);
        }
        return augend;
    }
}
