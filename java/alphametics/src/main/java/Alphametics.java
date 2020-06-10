import java.util.*;

public class Alphametics {

    public static final int UNASSIGNED = -1;
    private final List<String> _addends;
    private final String _targetSum;
    private HashSet<Character> _uniqueCharSet;

    public Alphametics(String expression) {
        storeUniqueCharacters(expression);

        int equalsIndex = expression.indexOf("==");

        String leftHand = expression.substring(0, equalsIndex - 1);

        _addends = new ArrayList<String>();
        String[] split = leftHand.split("\\+");
        for (String addend :
                split) {
            _addends.add(addend.trim());
        }

        _targetSum = expression.substring(equalsIndex + "== ".length());
    }

    private void storeUniqueCharacters(String expression) {
        String justLetters = expression.replaceAll("[^a-zA-Z0-9]", "");
        _uniqueCharSet = new HashSet();
        for (int i = 0; i < justLetters.length(); i++) {
            _uniqueCharSet.add(justLetters.charAt(i));
        }
    }

    public LinkedHashMap<Character, Integer> solve() throws UnsolvablePuzzleException {
        LinkedHashMap<Character, Integer> candidateSet = new LinkedHashMap<>();
        for (Character c :
                _uniqueCharSet) {
            candidateSet.put(c, UNASSIGNED);
        }
        
        int depth = 0;
        List<Integer> numbersInPlay = new ArrayList<>();
        if (digForSolution(depth, numbersInPlay, candidateSet)) {
            return candidateSet;
        }

        throw new UnsolvablePuzzleException();
    }

    private boolean digForSolution(int depth, List<Integer> numbersInPlay, LinkedHashMap<Character, Integer> candidateSet) {
        if (depth == candidateSet.size()) {
            return evaluate(candidateSet);
        }

        int tryThisNumber = 0;

        while (tryThisNumber < 10) {
            if (numbersInPlay.contains(tryThisNumber)) {
                tryThisNumber++;
            } else {
                numbersInPlay.add(tryThisNumber);
                Object[] keys = candidateSet.keySet().toArray();
                candidateSet.put((Character) keys[depth], tryThisNumber);

                if (depth < candidateSet.size()) {
                    depth++;
                    if (digForSolution(depth, numbersInPlay, candidateSet)) {
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

    private boolean evaluate(LinkedHashMap<Character, Integer> candidates) {
        if (anyLeadingZeros(candidates)) {
            return false;
        }

        long currentSum = 0;
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

    private long valueFor(String addend, LinkedHashMap<Character, Integer> candidates) {
        String numbersForAddend = "";
        for (int i = 0; i < addend.length(); i++) {
            numbersForAddend += candidates.get(addend.charAt(i));
        }

        return Long.parseLong(numbersForAddend);
    }
}
