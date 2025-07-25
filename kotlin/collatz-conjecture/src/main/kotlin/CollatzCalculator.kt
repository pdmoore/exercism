object CollatzCalculator {
    fun computeStepCount(n: Int, stepNumber: Int = 0): Int {
        require(n > 0) { "Only positive integers allowed" }

        when {
            n == 1     -> return stepNumber
            n.IsEven() -> return computeStepCount(n / 2, stepNumber + 1)
            else       -> return computeStepCount(n * 3 + 1, stepNumber + 1)
        }
    }
}

private fun Int.IsEven() = this % 2 == 0
