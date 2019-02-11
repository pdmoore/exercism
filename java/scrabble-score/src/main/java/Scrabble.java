class Scrabble {

    private int score;

    Scrabble(String word) {
        computeScore(word);
    }

    int getScore() {
        return score;
    }

    private void computeScore(String word) {
        for (char c: word.toLowerCase().toCharArray()) {

            if (c == 'q' || c == 'z') score += 10;
            else if (c == 'j' || c == 'x') score += 8;
            else if (c == 'k') score += 5;
            else if (c == 'f' || c == 'h' || c == 'v' || c == 'w' || c == 'y') score += 4;
            else if (c == 'b' || c == 'c' || c == 'm' || c == 'p') score += 3;
            else if (c == 'd' || c == 'g') score += 2;
            else score += 1;
        }
    }

}
