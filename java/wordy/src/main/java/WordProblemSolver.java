public class WordProblemSolver {


    //TODO - finsih with tests that check for errors
    //TODO - refactor

    public int solve(String problem) {
        problem = problem.replace("?", "");
        String[] words = problem.split(" ");

        int answer = 0;
        if (words.length == 3) {
            answer = Integer.parseInt(words[2]);
        } else {
            int operand1 = Integer.parseInt(words[2]);
            int operand2 = -0;

            for (int i = 3; i < words.length - 1; i++) {

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
                }

            }


        }

        return answer;
    }
}
