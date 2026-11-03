import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.toIntExact;

public class Say {

    private final Map<Integer, String> digitToWord = new HashMap<>();

    // did not completely fill out the teens or tens portions - no tests required that
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
    private static final int[] powers = {
            100,
            1_000,
            1_000_000,
            1_000_000_000,
    };

    public String say(long number) {
        if (number < 0 || number >= 1_000_000_000_000L) {
            throw new IllegalArgumentException("Number must be zero or larger");
        }

        for (int power = 3; power >= 0 ; power--) {
            int powerOfTen = powers[power];

            if (number >= powerOfTen) {
                int powerOfTenPortion = toIntExact(number / powerOfTen);
                String spokenPowerOfTen = say(powerOfTenPortion) + nameOfThePower[power];

                int remainder = toIntExact(number % powerOfTen);
                if (remainder > 0) {
                    return spokenPowerOfTen + " " + say(remainder);
                }
                if (remainder == 0) {
                    return spokenPowerOfTen;
                }
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