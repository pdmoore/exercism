public class WordProblemSolver {


    //TODO - finsih with tests that check for errors
    //TODO - refactor

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
                throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
            }

            int operand1 = 0;
            try {
                operand1 = Integer.parseInt(words[2]);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
            }

            int operand2 = 0;

            for (int i = 3; i < words.length - 1; i++) {

                try {

                    String operation = words[i];
                    if ("plus".equals(operation)) {
                        operand2 = Integer.parseInt(words[i + 1]);
                        answer = operand1 + operand2;

                        operand1 = answer;
                    } else if ("minus".equals(operation)) {
                        operand2 = Integer.parseInt(words[i + 1]);
                        answer = operand1 - operand2;

                        operand1 = answer;
                    } else if ("multiplied".equals(operation)) {
                        operand2 = Integer.parseInt(words[i + 2]);
                        answer = operand1 * operand2;

                        operand1 = answer;
                    } else if ("divided".equals(operation)) {
                        operand2 = Integer.parseInt(words[i + 2]);
                        answer = operand1 / operand2;

                        operand1 = answer;
                    } else {
                        System.out.println(operation);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
                }

            }


        }

        return answer;
    }

    private void validateProblemStatement(String problem) {
        String[] words = problem.split(" ");

        if (!"What".equals(words[0]) || (problem.contains("cubed"))) {

            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }

//        if (words.length > 3) {
//            if ("plus".equals(words[3])) {
//                if (words.length <= 4) {
//                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
//                }
//            }
//
//        }
    }
}
