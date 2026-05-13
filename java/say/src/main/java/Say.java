import java.util.HashMap;
import java.util.Map;

public class Say {

    private final Map<Integer, String> digitToWord = new HashMap<>();

    // 2026-05-13
    // tests are passing but have not completed exercise
    // Converting hard-coded strings to large_number array refs
    // need to add "hundred" on 74/77 and adjust index in other places
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
    private static final String[] large_numbers = { "", " thousand", " million", " billion" };

    public String say(long number) {
        if (number < 0 || number >= 1_000_000_000_000L) {
            throw new IllegalArgumentException("Number must be zero or larger");
        }

        // duplication for 100 vs 1xx -
        if (number > 999_999_999) {
            int billions = Math.toIntExact(number / 1_000_000_000);
            int remainder = Math.toIntExact(number % 1_000_000_000);
            if (remainder > 0) {
                return say(billions) + large_numbers[3] + " " + say(remainder);
            }

            return say(1) + large_numbers[3];
        }

        if (number > 999_999) {
            int millions = Math.toIntExact(number / 1_000_000);
            int remainder = Math.toIntExact(number % 1_000_000);
            if (remainder > 0) {
                return say(millions) + large_numbers[2] + " " + say(remainder);
            }

            return say(1) + large_numbers[2];
        }


        if (number > 999) {
            int thousands = Math.toIntExact(number / 1_000);
            int remainder = Math.toIntExact(number % 1_000);
            if (remainder > 0) {
                return say(thousands) + large_numbers[1] + " " + say(remainder);
            }

            return digitToWord.get(thousands) + large_numbers[1];
        }

        if (number > 99) {
            int hundreds = Math.toIntExact(number / 100);
            int remainder = Math.toIntExact(number % 100);
            if (remainder > 0) {
                return digitToWord.get(hundreds) + " hundred" + " " + say(remainder);
            }

            return digitToWord.get(hundreds) + " hundred";
        }

        if (number > 20) {
            int tens = Math.toIntExact(number / 10);

            int remainder = Math.toIntExact(number % 10);
            if (remainder > 0) {
                return digitToWord.get(tens * 10) + "-" + digitToWord.get(remainder);
            }
        }

        return digitToWord.get(Math.toIntExact(number));
    }
}