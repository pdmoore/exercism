import java.util.function.IntBinaryOperator;

public class WordProblemSolver {
    public static final String INVALID_QUESTION_MESSAGE = "I'm sorry, I don't understand the question!";


    //TODO - refactor

    public int solve(String problem) {
        validateProblemStatement(problem);

        String[] words = getWordsInTheProblem(problem);

        if (askingForNumber(words)) {
            return getNumber(words, 2);
        }

        if (problemIsMissingWords(words)) {
            throw new IllegalArgumentException(INVALID_QUESTION_MESSAGE);
        }

        int operand1 = getNumber(words, 2);

        int answer = 0;
        int i = 3;
        while (i < words.length) {
            int operand2 = 0;
            IntBinaryOperator operator;

            String operation = words[i];
            if ("plus".equals(operation)) {
                operator = Math::addExact;
                operand2 = getNumber(words, i + 1);
                i += 2;
            } else if ("minus".equals(operation)) {
                operator = Math::subtractExact;
                operand2 = getNumber(words, i + 1);
                i += 2;
            } else if ("multiplied".equals(operation)) {
                operator = Math::multiplyExact;
                operand2 = getNumber(words, i + 2);
                i += 3;
            } else if ("divided".equals(operation)) {
                operator = Math::floorDiv;
                operand2 = getNumber(words, i + 2);
                i += 3;
            } else {
                throw new IllegalArgumentException(INVALID_QUESTION_MESSAGE);
            }

            answer = operator.applyAsInt(operand1, operand2);
            operand1 = answer;
        }

        return answer;
    }

    private int getNumber(String[] words, int i) {
        try {
            return Integer.parseInt(words[i]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_QUESTION_MESSAGE);
        }
    }

    private boolean problemIsMissingWords(String[] words) {
        return words.length <= 4;
    }

    private boolean askingForNumber(String[] words) {
        return words.length == 3;
    }

    private String[] getWordsInTheProblem(String problem) {
        problem = problem.replace("?", "");
        return problem.split(" ");
    }

    private void validateProblemStatement(String problem) {
        String[] words = problem.split(" ");

        if (!"What".equals(words[0]) || (problem.contains("cubed"))) {
            throw new IllegalArgumentException(INVALID_QUESTION_MESSAGE);
        }
    }
}
