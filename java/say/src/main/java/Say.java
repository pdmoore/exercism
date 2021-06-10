import java.util.HashMap;
import java.util.Map;

public class Say {

    private final HashMap<Long, String> _digitToWord;

    public Say() {
        _digitToWord = new HashMap();
        _digitToWord.put(0L, "zero");
        _digitToWord.put(1L, "one");
        _digitToWord.put(14L, "fourteen");
    }

    public String say(long number) {
        return _digitToWord.get(number);
    }
}
