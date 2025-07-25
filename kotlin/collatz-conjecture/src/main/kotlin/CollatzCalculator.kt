object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        require(start > 0) { "Only positive integers allowed" }

        return countSteps(start, 0)
    }

    private fun countSteps(n: Int, stepNumber: Int): Int {
        when {
            n == 1 -> return stepNumber
            n.IsEven() -> return countSteps(n / 2, stepNumber + 1)
            else -> return countSteps(n * 3 + 1, stepNumber + 1)
        }
    }
}

private fun Int.IsEven() = this % 2 == 0
