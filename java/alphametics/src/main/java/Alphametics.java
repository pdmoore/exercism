import java.util.*;

public class Alphametics {

    public static final int UNASSIGNED = -1;
    private final List _addends;
    private final String _targetSum;
    private LinkedHashMap<Character, Integer> _result;
    private String _expression;
    private HashSet<Character> _uniqueCharSet;

    public Alphametics(String expression) {
        _expression = expression;
        _addends = new ArrayList<String>();

        storeUniqueCharacters(expression);

        int equalsIndex = _expression.indexOf("==");

        String leftHand = _expression.substring(0, equalsIndex - 1);

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
        _uniqueCharSet = new HashSet();
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
        // loop over possible values, don't duplicate values,
        // assign a value to each unique character

        // Need to try each addend
        // Need to track numbers in play or not
        // need to cycle through all the combos

        // create list of 0..9
        // loop over addends and assign a number
        // increase last most one until exhausted
        // then bump second to last and start over with last

        // feels like recursion....

        LinkedHashMap<Character, Integer> candidateSet = new LinkedHashMap<>();
        for (Character c :
                _result.keySet()) {
            candidateSet.put(c, UNASSIGNED);
        }

        for (int attempt = 0; attempt <= 9; attempt++) {

            candidateSet.put('I', attempt);
            candidateSet.put('B', 9);
            candidateSet.put('L', 0);

            if (evaluate(candidateSet)) {
                return candidateSet;
            }
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