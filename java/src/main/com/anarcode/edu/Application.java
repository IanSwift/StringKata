package main.com.anarcode.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator(new Parser(), new Adder(), new DelimeterDetector());
        while (true) {
            try {
                System.out.println("Enter numbers to add.");
                String input = in.readLine();
                System.out.println(calculator.add(input));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}