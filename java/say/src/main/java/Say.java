import java.util.HashMap;
import java.util.Map;

public class Say {

    private final Map<Integer, String> _digitToWord = new HashMap<>();

    public Say() {
        _digitToWord.put(0, "zero");
        _digitToWord.put(1, "one");
        _digitToWord.put(2, "two");
        _digitToWord.put(3, "three");
        _digitToWord.put(4, "four");
        _digitToWord.put(14, "fourteen");
        _digitToWord.put(20, "twenty");
        _digitToWord.put(30, "thirty");
    }

    public String say(long number) {
        // starting to recurse
        // very limited to 20-ish numbers and 100-ish numbers
        // sensing duplication for 100 vs 1xx -
        if (number > 999999) {
            return "one million";
        }


        if (number > 999) {
            int thousands = Math.toIntExact(number / 1000);
            int remainder = Math.toIntExact(number % 1000);
            if (remainder > 0) {
                return _digitToWord.get(thousands) + " thousand" + " " + say(remainder);
            }

            return _digitToWord.get(thousands) + " thousand";
        }

        if (number > 99) {
            int hundreds = Math.toIntExact(number / 100);
            int remainder = Math.toIntExact(number % 100);
            if (remainder > 0) {
                return _digitToWord.get(hundreds) + " hundred" + " " + say(remainder);
            }

            return _digitToWord.get(hundreds) + " hundred";
        }

        // not just 20.....remainder
        if (number > 20) {
            int tens = Math.toIntExact(number / 10);

            int remainder = Math.toIntExact(number % 10);
            return _digitToWord.get(tens * 10) + "-" + _digitToWord.get(remainder);
        }

        return _digitToWord.get(Math.toIntExact(number));
    }
}
