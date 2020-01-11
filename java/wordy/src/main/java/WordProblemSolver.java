public class WordProblemSolver {
    public static final String INVALID_QUESTION_MESSAGE = "I'm sorry, I don't understand the question!";


    //TODO - finish last two tests that check for errors
    //TODO - refactor
    // Change approach - determine what the operation is, then try to grab next correct values, throwing exception on error
    // do each operation one by one

    public int solve(String problem) {
        validateProblemStatement(problem);

        problem = problem.replace("?", "");
        String[] words = problem.split(" ");

        int answer = 0;
        if (words.length == 3) {
            answer = Integer.parseInt(words[2]);
        } else {
            // Check for missing operand on single plus operation
            if (words.length - 1 <= 3) {
                throw new IllegalArgumentException(INVALID_QUESTION_MESSAGE);
            }

            int operand1 = 0;
            try {
                operand1 = Integer.parseInt(words[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INVALID_QUESTION_MESSAGE);
            }

            int operand2 = 0;

//            for (int i = 3; i < words.length - 1; i++) {
            int i = 3;
            while (i < words.length) {

                try {
                    String operation = words[i];
                    if ("plus".equals(operation)) {
                        operand2 = Integer.parseInt(words[i + 1]);
                        answer = operand1 + operand2;

                        operand1 = answer;
                         i += 2;
                    } else if ("minus".equals(operation)) {
                        operand2 = Integer.parseInt(words[i + 1]);
                        answer = operand1 - operand2;

                        operand1 = answer;
                        i += 2;
                    } else if ("multiplied".equals(operation)) {
                        operand2 = Integer.parseInt(words[i + 2]);
                        answer = operand1 * operand2;

                        operand1 = answer;
                        i += 3;
                    } else if ("divided".equals(operation)) {
                        operand2 = Integer.parseInt(words[i + 2]);
                        answer = operand1 / operand2;

                        operand1 = answer;
                        i += 3;
                    } else {
                        throw new IllegalArgumentException(INVALID_QUESTION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(INVALID_QUESTION_MESSAGE);
                }

            }


        }

        return answer;
    }

    private void validateProblemStatement(String problem) {
        String[] words = problem.split(" ");

        if (!"What".equals(words[0]) || (problem.contains("cubed"))) {

            throw new IllegalArgumentException(INVALID_QUESTION_MESSAGE);
        }
    }
}
