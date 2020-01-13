class CollatzCalculator {

    private int step;

    public CollatzCalculator() {
        step = 0;
    }

    int computeStepCount(int start) {
        if (start <= 0) {
            throw new IllegalArgumentException("Only natural numbers are allowed");
        }

        int i = start;
        while (i > 1) {
            i = nextStep(i);
        }

        return step;
    }

    private int nextStep(int i) {
        step++;

        if (i % 2 == 0) {
            return i / 2;
        } else {
            return (i * 3) + 1;
        }
    }

}
