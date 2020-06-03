import java.util.HashSet;
import java.util.LinkedHashMap;

public class Alphametics {

    private LinkedHashMap<Character, Integer> result;

    public Alphametics(String expression) {
        //split expression
        // - into components (things added, result after the equals)
        // - the unique letters



        // Following grabs unique characters out of the expression
        String justLetters = expression.replaceAll("[^a-zA-Z0-9]", "");
        HashSet < Character> uniqueCharSet= new HashSet();
        for(int i=0;i < justLetters.length();i++)
        {
            uniqueCharSet.add(justLetters.charAt(i));
        }

        result = new LinkedHashMap<>();

        for (Character key :
                uniqueCharSet) {
            result.put(key, -99);
        }


        // need to get the addends (things added A + B + C)
        // need to get the sum (thing to right of = sign)



    }

    public LinkedHashMap<Character, Integer> solve() {

        // Need an algorithm to solve the expression
        // brute force?

        // Need to sort result by value

//        "I + BB == ILL"
//        expected.put('I', 1);
//        expected.put('B', 9);
//        expected.put('L', 0);

        return result;
    }
}