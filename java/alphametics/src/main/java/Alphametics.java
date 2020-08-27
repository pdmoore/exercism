import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Alphametics {

    public static final int UNASSIGNED = -1;
    private final List<String> _addends;
    private final String _targetSum;
    private final HashSet<Character> _initialCharacters;
    private final LinkedHashMap<Character, Integer> _candidateSolution;
    Character[] _characters;
    private Character _zeroMappedTo;

    public Alphametics(String expression) {
        List<String> words = wordsFrom(expression);
        _addends = words.subList(0, words.size() - 1);
        _targetSum = words.get(words.size() - 1);
        _initialCharacters = initialLetterOfEach(words);

        _candidateSolution = initializeSolution(expression);
        _characters = _candidateSolution.keySet().toArray(new Character[0]);
    }

    private HashSet<Character> initialLetterOfEach(List<String> words) {
        HashSet<Character> result = new HashSet();
        for (String word :
                words) {
            result.add(word.charAt(0));
        }
        return result;
    }

    private List<String> wordsFrom(String expression) {
        return Stream.of(expression.split("\\+|=="))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private LinkedHashMap<Character, Integer> initializeSolution(String expression) {
        LinkedHashMap<Character, Integer> empty = new LinkedHashMap<>();
        for (Character c :
                getUniqueCharactersFrom(expression)) {
            empty.put(c, UNASSIGNED);
        }
        return empty;
    }

    private Collection<Character> getUniqueCharactersFrom(String expression) {
        String justTheLetters = expression.replaceAll("[^a-zA-Z0-9]", "");

        return justTheLetters.chars().
                distinct().
                sorted().
                mapToObj(c -> (char) c).
                collect(Collectors.toList());
    }

    public LinkedHashMap<Character, Integer> solve() throws UnsolvablePuzzleException {
        int depth = 0;
        List<Integer> numbersInPlay = new ArrayList<>();
        if (digForSolution(depth, numbersInPlay, _candidateSolution)) {
            return _candidateSolution;
        }

        throw new UnsolvablePuzzleException();
    }

    private boolean digForSolution(int depth, List<Integer> numbersInPlay, LinkedHashMap<Character, Integer> candidateSet) {
        if (depth == candidateSet.size()) {
            return equationIsSolvedBy(candidateSet);
        }

        int tryThisNumber = 0;
        while (tryThisNumber < 10) {
            if (numbersInPlay.contains(tryThisNumber) ||
                (tryThisNumber == 0 && _initialCharacters.contains(_characters[depth]))) {
                tryThisNumber++;
            } else {
                numbersInPlay.add(tryThisNumber);
                candidateSet.put(_characters[depth], tryThisNumber);

                depth++;
                if (digForSolution(depth, numbersInPlay, candidateSet)) {
                    return true;
                }
                depth--;

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
        return _initialCharacters.contains(_zeroMappedTo);
    }

    private long valueFor(String numberAsWord, LinkedHashMap<Character, Integer> candidates) {
        String wordAsNumbers = "";
        for (int i = 0; i < numberAsWord.length(); i++) {
            wordAsNumbers += candidates.get(numberAsWord.charAt(i));
        }

        return Long.parseLong(wordAsNumbers);
    }
}
