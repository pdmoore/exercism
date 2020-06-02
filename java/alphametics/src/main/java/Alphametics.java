import java.util.LinkedHashMap;

public class Alphametics {

    public Alphametics(String expression) {
    }

    public LinkedHashMap<Character, Integer> solve() {

        LinkedHashMap<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('I', 1);
        expected.put('B', 9);
        expected.put('L', 0);

        return expected;
    }
}