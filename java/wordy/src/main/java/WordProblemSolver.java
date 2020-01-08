public class WordProblemSolver {


    public int solve(String problem) {
        problem = problem.replace("?", "");
        String[] words = problem.split(" ");

        int answer = Integer.parseInt(words[2]);

        return answer;
    }
}
