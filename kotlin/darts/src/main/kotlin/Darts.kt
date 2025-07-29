import kotlin.math.sqrt

object Darts {
    fun score(x: Int, y: Int): Int {
        return score(x.toDouble(), y.toDouble())
    }

    fun score(x: Double, y: Double): Int {
        val distance = sqrt((x * x) + (y * y))

        when {
            distance in 0.0..1.0 -> return 10
            distance in 1.0..5.0 -> return 5
            distance <= 10.0 -> return 1
            else -> return 0
        }
    }

    fun score(x: Double, y: Int): Int {
        return score(x, y.toDouble())
    }
}