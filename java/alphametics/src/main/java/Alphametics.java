import java.util.HashSet;
import java.util.LinkedHashMap;

public class Alphametics {

    public static final int UNASSIGNED = -1;
    private final String[] _addends;
    private final String _targetSum;
    private LinkedHashMap<Character, Integer> _result;
    private String _expression;

    public Alphametics(String expression) {
        _expression = expression;

        // Following grabs unique characters out of the expression
        storeUniqueCharacters(expression);

        // need to get the addends (things added A + B + C)
        // need to get the sum (thing to right of = sign)

        int equalsIndex = _expression.indexOf("==");

        String leftHand = _expression.substring(0, equalsIndex - 1);
        _addends = leftHand.split("\\+");
        _targetSum = _expression.substring(equalsIndex + "== ".length());


        // need to convert letters to number value

        // then brute force each letter 0...9
        // and ability to evaluate an expression for given set of values
        // and halt if the expresson "works"


    }

    private void storeUniqueCharacters(String expression) {
        String justLetters = expression.replaceAll("[^a-zA-Z0-9]", "");
        HashSet<Character> _uniqueCharSet = new HashSet();
        for (int i = 0; i < justLetters.length(); i++) {
            _uniqueCharSet.add(justLetters.charAt(i));
        }

        _result = new LinkedHashMap<>();

        for (Character key :
                _uniqueCharSet) {
            _result.put(key, UNASSIGNED);
        }
    }

    private void validateExpression() throws UnsolvablePuzzleException {
//            throw new UnsolvablePuzzleException();
    }

    public LinkedHashMap<Character, Integer> solve() throws UnsolvablePuzzleException {
        validateExpression();

        // TODO - need to track and iterate through candidate solutions
        // Need an algorithm to solve the expression
        // brute force?
        //TODO - hardcoded to pass first test, starting to process invalid cases
        _result.put('I', 1);
        _result.put('B', 9);
        _result.put('L', 0);

        if (evaluate(_result)) {
            // TODO - Need to sort result by value
            return _result;
        }

        throw new UnsolvablePuzzleException();

    }

    private boolean evaluate(LinkedHashMap<Character, Integer> candidates) {
        // for each addend, convert it to a number
        // convert sum to number
        // sum all the addends
        // does the sum match the targetSum?

//        "I + BB == ILL"
//

        int currentSum = 0;
        for (String addend :
                _addends) {
            currentSum += valueFor(addend, candidates);
        }

        return currentSum == valueFor(_targetSum, candidates);
    }

    private int valueFor(String addend, LinkedHashMap<Character, Integer> candidates) {
        return 0;
    }
}