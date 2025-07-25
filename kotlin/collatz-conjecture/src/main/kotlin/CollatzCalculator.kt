import javax.print.attribute.standard.QueuedJobCount

object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start <= 0) throw IllegalArgumentException("start")

        return countSteps(start, 0)
    }

    private fun countSteps(start: Int, count: Int): Int {
        if (start == 1) return count

        if (start % 2 == 0) return countSteps(start / 2, count + 1)

        return countSteps(start * 3 + 1, count + 1)
    }
}
