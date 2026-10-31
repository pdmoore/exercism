import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.*;

public class Say {

    private final Map<Integer, String> digitToWord = new HashMap<>();

    // 2026-10-30
    // Prepped for the collapsing of logic and looping through billion, million, thousand, hundred
    // see the SayTest for the power expression to use in the loop
    // tests are passing but have not completed exercise
    // Converting hard-coded strings to large_number array refs
    // need to collapse duplicate logic for billion/million/thousand/hundred


    public Say() {
        digitToWord.put(0, "zero");
        digitToWord.put(1, "one");
        digitToWord.put(2, "two");
        digitToWord.put(3, "three");
        digitToWord.put(4, "four");
        digitToWord.put(5, "five");
        digitToWord.put(6, "six");
        digitToWord.put(7, "seven");
        digitToWord.put(9, "nine");
        digitToWord.put(14, "fourteen");
        digitToWord.put(20, "twenty");
        digitToWord.put(30, "thirty");
        digitToWord.put(40, "forty");
        digitToWord.put(50, "fifty");
        digitToWord.put(80, "eighty");
        digitToWord.put(90, "ninety");
    }
    private static final String[] large_numbers = { " hundred", " thousand", " million", " billion" };

    public String say(long number) {
        if (number < 0 || number >= 1_000_000_000_000L) {
            throw new IllegalArgumentException("Number must be zero or larger");
        }

        // loop from 3 to 0
        // power from 9/6/3/2

        int large_number_index = 3;
        int powerOfTen = (int) Math.pow(10, large_number_index * 3);
        if (number > powerOfTen - 1) {
            int billions = toIntExact(number / powerOfTen);
            int remainder = toIntExact(number % powerOfTen);
            if (remainder > 0) {
                return say(billions) + large_numbers[large_number_index] + " " + say(remainder);
            }

            return say(1) + large_numbers[large_number_index];
        }

        large_number_index = 2;
        powerOfTen = (int) Math.pow(10, large_number_index * 2);

        if (number > powerOfTen - 1) {
            int millions = toIntExact(number / powerOfTen);
            int remainder = toIntExact(number % powerOfTen);
            if (remainder > 0) {
                return say(millions) + large_numbers[large_number_index] + " " + say(remainder);
            }

            return say(1) + large_numbers[large_number_index];
        }

        large_number_index = 1;
        powerOfTen = (int) Math.pow(10, large_number_index * 1);

        if (number > powerOfTen - 1) {
            int thousands = toIntExact(number / powerOfTen);
            int remainder = toIntExact(number % powerOfTen);
            if (remainder > 0) {
                return say(thousands) + large_numbers[large_number_index] + " " + say(remainder);
            }

            return digitToWord.get(thousands) + large_numbers[large_number_index];
        }

        large_number_index = 0;
        powerOfTen = (int) Math.pow(10, large_number_index * 1);

        if (number > powerOfTen - 1) {
            int hundreds = toIntExact(number / powerOfTen);
            int remainder = toIntExact(number % powerOfTen);
            if (remainder > 0) {
                return digitToWord.get(hundreds) + large_numbers[large_number_index] + " " + say(remainder);
            }

            return digitToWord.get(hundreds) + large_numbers[large_number_index];
        }

        if (number > 20) {
            int tens = toIntExact(number / 10);

            int remainder = toIntExact(number % 10);
            if (remainder > 0) {
                return digitToWord.get(tens * 10) + "-" + digitToWord.get(remainder);
            }
        }

        return digitToWord.get(toIntExact(number));
    }
}