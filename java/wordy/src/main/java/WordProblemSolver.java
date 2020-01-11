import java.util.function.IntBinaryOperator;

public class WordProblemSolver {
    public static final String INVALID_QUESTION_MESSAGE = "I'm sorry, I don't understand the question!";

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
        int indexOfOperation = 3;
        while (indexOfOperation < words.length) {
            MathActions action = createAction(words[indexOfOperation]);
            int operand2 = getNumber(words, indexOfOperation + action.operand2Offset);
            answer = action.operator.applyAsInt(operand1, operand2);

            operand1 = answer;
            indexOfOperation += action.incrementToNextOperation;
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
        // could check words[1,2] are "what is" instead
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

    private MathActions createAction(String operation) {
        switch (operation) {
            case "plus":
                return new Addition();
            case "minus":
                return new Subtraction();
            case "multiplied":
                return new Multiplication();
            case "divided":
                return new Division();
        }

        throw new IllegalArgumentException(INVALID_QUESTION_MESSAGE);
    }


    private abstract class MathActions {
        public IntBinaryOperator operator;
        public int operand2Offset;
        public int incrementToNextOperation;
    }

    private class Addition extends MathActions {
        public Addition() {
            operator = Math::addExact;
            operand2Offset = 1;
            incrementToNextOperation = 2;
        }
    }

    private class Subtraction extends MathActions {
        public Subtraction() {
            operator = Math::subtractExact;
            operand2Offset = 1;
            incrementToNextOperation = 2;
        }
    }

    private class Multiplication extends MathActions {
        public Multiplication() {
            operator = Math::multiplyExact;
            operand2Offset = 2;
            incrementToNextOperation = 3;
        }
    }

    private class Division extends MathActions {
        public Division() {
            operator = Math::floorDiv;
            operand2Offset = 2;
            incrementToNextOperation = 3;
        }
    }
}
