object CollatzCalculator {
    fun computeStepCount(num: Int, stepNumber: Int = 0): Int {
        require(num > 0) { "Only positive integers allowed" }

        return generateSequence(num) {
            n -> if (n % 2 == 0) n / 2
                 else n * 3 + 1 }.indexOf(1)
    }
}
