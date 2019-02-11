class Darts {

    private final int score;

    Darts(double x, double y) {
        score = calculate(x, y);
    }

    private int calculate(double x, double y) {
        if (Math.abs(x - y) < 0.01) return 10;
        if ((x <= 5) && (y <= 5)) return 5;
        if (x <= 10) return 1;
        return 0;
    }

    int score() {
        return score;
    }

}
