class CollatzCalculator {

    int computeStepCount(int start) {
        if (start <= 0) {
            throw new IllegalArgumentException("Only natural numbers are allowed");
        }

        int step = 0;
        int i = start;
        while (i > 1) {
            step++;

            if (i % 2 == 0) {
                i = i / 2;
            } else {
                i = (i * 3) + 1;
            }
        }

        return step;
    }

}
