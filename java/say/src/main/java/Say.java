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
    private static final String[] nameOfThePower = { " hundred", " thousand", " million", " billion" };

    public String say(long number) {
        if (number < 0 || number >= 1_000_000_000_000L) {
            throw new IllegalArgumentException("Number must be zero or larger");
        }

        for (int power = 3; power > 0 ; power--) {
            int tenToThePower = (int) Math.pow(10, power * 3);
            if (number > tenToThePower - 1) {
                int numberAboveThePower = toIntExact(number / tenToThePower);
                int remainder = toIntExact(number % tenToThePower);
                if (remainder > 0) {
                    return say(numberAboveThePower) + nameOfThePower[power] + " " + say(remainder);
                }

                return say(1) + nameOfThePower[power];
            }
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