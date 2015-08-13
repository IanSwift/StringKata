package main.com.anarcode.edu;

public class DelimeterDetector implements DelimeterDetectorInterface {
    @Override
    public Character findDelimeter(String s) {
        if (s.length() >= 4 && s.substring(0,2).equals("//") && s.charAt(3) == '\n')
        {
            return s.charAt(2);
        }
        return null;
    }
}
