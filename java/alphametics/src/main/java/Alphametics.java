import java.util.*;

public class Alphametics {

    public static final int UNASSIGNED = -1;
    public static final String EQUALS = "==";
    private final List<String> _addends;
    private final String _targetSum;
    private HashSet<Character> _uniqueCharSet;

    public Alphametics(String expression) {
        _uniqueCharSet = getUniqueCharactersFrom(expression);
        _addends = getAddendsFrom(expression);
        _targetSum = getSumFrom(expression);
    }

    private HashSet<Character> getUniqueCharactersFrom(String expression) {
        String justLetters = expression.replaceAll("[^a-zA-Z0-9]", "");
        HashSet<Character> uniqueCharSet = new HashSet();
        for (int i = 0; i < justLetters.length(); i++) {
            uniqueCharSet.add(justLetters.charAt(i));
        }
        return uniqueCharSet;
    }

    private List<String> getAddendsFrom(String expression) {
        int equalsIndex = expression.indexOf(EQUALS);
        String leftHand = expression.substring(0, equalsIndex - 1);

        ArrayList<String> addends = new ArrayList<String>();
        String[] split = leftHand.split("\\+");
        for (String addend :
                split) {
            addends.add(addend.trim());
        }

        return addends;
    }

    private String getSumFrom(String expression) {
        int equalsIndex = expression.indexOf(EQUALS);
        return expression.substring(equalsIndex + EQUALS.length() + 1);
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
            return equationIsSolvedBy(candidateSet);
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

    private boolean equationIsSolvedBy(LinkedHashMap<Character, Integer> candidateSet) {
        if (anyLeadingZeros(candidateSet)) {
            return false;
        }

        long currentSum = 0;
        for (Iterator it = _addends.iterator(); it.hasNext(); ) {
            String addend = (String) it.next();
            currentSum += valueFor(addend, candidateSet);
        }

        return currentSum == valueFor(_targetSum, candidateSet);
    }

    private boolean anyLeadingZeros(LinkedHashMap<Character, Integer> candidateSet) {
        for (String addend :
                _addends) {
            char initialChar = addend.charAt(0);
            if (candidateSet.get(initialChar) == 0) {
                return true;
            }
        }

        char initialChar = _targetSum.charAt(0);
        if (candidateSet.get(initialChar) == 0) {
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
