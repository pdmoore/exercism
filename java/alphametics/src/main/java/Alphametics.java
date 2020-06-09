import java.util.*;

public class Alphametics {

    public static final int UNASSIGNED = -1;
    private final List<String> _addends;
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
        for (String addend :
                split) {
            _addends.add(addend.trim());
        }

        _targetSum = _expression.substring(equalsIndex + "== ".length());
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
        if (_uniqueCharSet.size() == 2)
            throw new UnsolvablePuzzleException();
    }

    public LinkedHashMap<Character, Integer> solve() throws UnsolvablePuzzleException {
        validateExpression();

        LinkedHashMap<Character, Integer> candidateSet = new LinkedHashMap<>();
        for (Character c :
                _result.keySet()) {
            candidateSet.put(c, UNASSIGNED);
        }

        List<Integer> availableNumbers = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            availableNumbers.add(i);
        }

        // These are the letters that need to be filled in
        Object[] keys = candidateSet.keySet().toArray();
        int depth = 0;
        List<Integer> numbersInPlay = new ArrayList<>();
        if (digForSolution(depth, numbersInPlay, candidateSet, keys)) {
            return candidateSet;
        }

        throw new UnsolvablePuzzleException();
    }

    private boolean digForSolution(int depth, List<Integer> numbersInPlay, LinkedHashMap<Character, Integer> candidateSet, Object[] keys) {
        if (depth >= candidateSet.size()) {
            return evaluate(candidateSet);
        }

        int tryThisNumber = 0;

        while (tryThisNumber < 10) {
            if (numbersInPlay.contains(tryThisNumber)) {
                tryThisNumber++;
            } else {
                numbersInPlay.add(tryThisNumber);
                candidateSet.put((Character) keys[depth], tryThisNumber);

                if (depth < candidateSet.size()) {
                    depth++;
                    if (digForSolution(depth, numbersInPlay, candidateSet, keys)) {
                        return true;
                    }
                    depth--;
                }
                numbersInPlay.remove((Integer) tryThisNumber);
                tryThisNumber++;
            }
        }

        return false;
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
        if (anyLeadingZeros(candidates)) {
            return false;
        }

        int currentSum = 0;
        for (Iterator it = _addends.iterator(); it.hasNext(); ) {
            String addend = (String) it.next();
            currentSum += valueFor(addend, candidates);
        }

        return currentSum == valueFor(_targetSum, candidates);
    }

    private boolean anyLeadingZeros(LinkedHashMap<Character, Integer> candidates) {
        for (String addend :
                _addends) {
            char initialChar = addend.charAt(0);
            if (candidates.get(initialChar) == 0) {
                return true;
            }
        }

        char initialChar = _targetSum.charAt(0);
        if (candidates.get(initialChar) == 0) {
            return true;
        }

        return false;
    }

    private int valueFor(String addend, LinkedHashMap<Character, Integer> candidates) {
        String numbersForAddend = "";
        for (int i = 0; i < addend.length(); i++) {
            numbersForAddend += candidates.get(addend.charAt(i));
        }

        return Integer.parseInt(numbersForAddend);
    }
}
