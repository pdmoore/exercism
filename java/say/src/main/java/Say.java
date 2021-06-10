import java.util.HashMap;
import java.util.Map;

public class Say {

    private final HashMap<Integer, String> _digitToWord;

    public Say() {
        _digitToWord = new HashMap();
        _digitToWord.put(0, "zero");
        _digitToWord.put(1, "one");
        _digitToWord.put(2, "two");
        _digitToWord.put(3, "three");
        _digitToWord.put(14, "fourteen");
        _digitToWord.put(20, "twenty");
    }

    public String say(long number) {
        if (number > 99) {
            int hundreds = (int) (number / 100);
            int remainder = (int) (number % 100);
            if (remainder > 0) {
                return _digitToWord.get(hundreds) + " hundred" + " " + say(remainder);
            }

            return _digitToWord.get(hundreds) + " hundred";
        }

        if (number > 20) {
            int remainder = (int) (number % 20);
            return _digitToWord.get(20) + "-" + _digitToWord.get(remainder);
        }

        return _digitToWord.get((int) number);
    }
}
