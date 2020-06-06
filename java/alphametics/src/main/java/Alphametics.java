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

        LinkedHashMap<Character, Integer> candidateSet = new LinkedHashMap<>();
        for (Character c :
                _result.keySet()) {
            candidateSet.put(c, UNASSIGNED);
        }

        // TODO NEXT TIME
        // loop over possible values, don't duplicate values,
        // assign a value to each unique character

        // create one list of 0..9 per each addend
        // for each addend, grab a number, confirm it is not in play yet, assign it to candidateSet
        // try candidateSet
        // 0,1  0,2  0,3  0,4  0,5  0,6  0,7  0,8  0,9
        // 1,0  1,2  1,3  1,4  1,5  1,6  1,7  1,8  1,9

        // list of available numbers 0..9
        // list of attempted numbers, one list per unique character
        // or string of attempts - 012, 013, 014, etc save that in a list to make sure no dupes

        // These are the letters that need to be filled in
//        candidateSet.keySet();

        List<String> attempts = new ArrayList<>();

        Object[] keys = candidateSet.keySet().toArray();


        for (int tryThisNumber = 0; tryThisNumber <= 9; tryThisNumber++) {

            candidateSet.put((Character) keys[1], tryThisNumber);
            candidateSet.put('B', 9);
            candidateSet.put('L', 0);

            // create a stamp of this attempted combination
            String thisAttempt = valuesOf(candidateSet);

            // if it hasn't been tried before...
            if (!attempts.contains(thisAttempt)) {
                attempts.add(thisAttempt);

                if (evaluate(candidateSet)) {
                    return candidateSet;
                }
            }
        }

        throw new UnsolvablePuzzleException();
    }

    private String valuesOf(LinkedHashMap<Character, Integer> candidateSet) {
        String result = "";
        for (Integer value :
                candidateSet.values()) {
            result += value;
        }
        return result;
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