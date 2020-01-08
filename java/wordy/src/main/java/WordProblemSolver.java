public class WordProblemSolver {


    public int solve(String problem) {
        problem = problem.replace("?", "");
        String[] words = problem.split(" ");

        int answer = 0;
        if (words.length == 3) {
            answer = Integer.parseInt(words[2]);
        } else {
            int operand1 = Integer.parseInt(words[2]);
            int operand2 = Integer.parseInt(words[4]);

            answer = operand1 + operand2;
        }

        return answer;
    }
}
