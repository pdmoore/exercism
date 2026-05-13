import java.util.HashMap;
import java.util.Map;

public class Say {

    private final Map<Integer, String> digitToWord = new HashMap<>();

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

    public String say(long number) {
        if (number < 0 || number >= 1_000_000_000_000L) {
            throw new IllegalArgumentException("Number must be zero or larger");
        }

        // duplication for 100 vs 1xx -
        if (number > 999_999_999) {
            int billions = Math.toIntExact(number / 1_000_000_000);
            int remainder = Math.toIntExact(number % 1_000_000_000);
            if (remainder > 0) {
                return say(billions) + " billion" + " " + say(remainder);
            }

            return "one billion";
        }

        if (number > 999_999) {
            int millions = Math.toIntExact(number / 1_000_000);
            int remainder = Math.toIntExact(number % 1_000_000);
            if (remainder > 0) {
                return say(millions) + " million" + " " + say(remainder);
            }

            return "one million";
        }


        if (number > 999) {
            int thousands = Math.toIntExact(number / 1_000);
            int remainder = Math.toIntExact(number % 1_000);
            if (remainder > 0) {
                return say(thousands) + " thousand" + " " + say(remainder);
            }

            return digitToWord.get(thousands) + " thousand";
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