package main.com.anarcode.edu;

public class AdderCommaSeperated implements AdderInterface{
    @Override
    public int getResult(String s) {
        if (s == "") {
            return 0;
        }
        String[] split = s.split(",");
        int augend = 0;
        for (String addend : split) {
            augend += Integer.parseInt(addend);
        }
        return augend;
    }
}
