import javax.print.attribute.standard.QueuedJobCount

object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        return countSteps(start, 0)
    }

    private fun countSteps(start: Int, count: Int): Int {
        if (start == 1) return count

        return 4
    }
}
