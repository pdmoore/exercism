import java.util.HashSet;
import java.util.LinkedHashMap;

public class Alphametics {

    public static final int UNASSIGNED = -1;
    private final HashSet<Character> _uniqueCharSet;
    private LinkedHashMap<Character, Integer> _result;

    public Alphametics(String expression) {
        //split expression
        // - into components (things added, result after the equals)
        // - the unique letters

        // Following grabs unique characters out of the expression
        String justLetters = expression.replaceAll("[^a-zA-Z0-9]", "");
        _uniqueCharSet = new HashSet();
        for(int i=0;i < justLetters.length();i++)
        {
            _uniqueCharSet.add(justLetters.charAt(i));
        }

        _result = new LinkedHashMap<>();

        for (Character key :
                _uniqueCharSet) {
            _result.put(key, UNASSIGNED);
        }



        // need to get the addends (things added A + B + C)
        // need to get the sum (thing to right of = sign)


        // need to convert letters to number value

    }

    public LinkedHashMap<Character, Integer> solve() {

        // Need an algorithm to solve the expression
        // brute force?

        // Need to sort result by value

//        "I + BB == ILL"
//        expected.put('I', 1);
//        expected.put('B', 9);
//        expected.put('L', 0);




        return _result;
    }
}