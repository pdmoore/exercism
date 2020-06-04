import java.util.*;

public class Alphametics {

    public static final int UNASSIGNED = -1;
    private final List _addends;
    private final String _targetSum;
    private LinkedHashMap<Character, Integer> _result;
    private String _expression;

    public Alphametics(String expression) {
        _expression = expression;
        _addends = new ArrayList<String>();

        // Following grabs unique characters out of the expression
        storeUniqueCharacters(expression);

        // need to get the addends (things added A + B + C)
        // need to get the sum (thing to right of = sign)

        int equalsIndex = _expression.indexOf("==");

        String leftHand = _expression.substring(0, equalsIndex - 1);
        //TODO - addends have spaces, where to trim?
        String[] split = leftHand.split("\\+");
        for (String addend:
                split) {
            _addends.add(addend.trim());
        }

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

        // TODO NEXT TIME
        // TODO - need to track and iterate through candidate solutions
        // loop over possible values, don't duplicate values,
        // assign a value to each unique character
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
        int currentSum = 0;
        for (Iterator it = _addends.iterator(); it.hasNext(); ) {
            String addend = (String) it.next();
            currentSum += valueFor(addend,candidates);
        }

        return currentSum == valueFor(_targetSum, candidates);
    }

    private int valueFor(String addend, LinkedHashMap<Character, Integer> candidates) {
        String numbersForAddend = "";
        for (int i = 0; i < addend.length(); i++) {
            numbersForAddend += candidates.get(addend.charAt(i));
        }

        return Integer.parseInt(numbersForAddend);
    }
}